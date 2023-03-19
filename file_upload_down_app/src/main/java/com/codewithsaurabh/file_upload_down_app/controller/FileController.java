package com.codewithsaurabh.file_upload_down_app.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.codewithsaurabh.file_upload_down_app.model.DbImageFile;
import com.codewithsaurabh.file_upload_down_app.model.DbProduct;
import com.codewithsaurabh.file_upload_down_app.payload.Response;
import com.codewithsaurabh.file_upload_down_app.repository.DatabaseProductRepository;
import com.codewithsaurabh.file_upload_down_app.service.DatabaseFileService;
import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class FileController {
	@Autowired
	private DatabaseFileService databaseStorageService;
	@Autowired
	private DatabaseProductRepository databaseProductRepository;

	@PostMapping("/uploadFile")
	public Response uploadFile(@RequestParam("image_cat_id") Integer image_cat_id,
			@RequestParam("file") MultipartFile file, @RequestParam("imageDesc") String imageDesc,
			@RequestParam("isProfile") boolean isProfile) {
		System.err.println("In FileController -> uploadFile!!!");
		DbImageFile fileName = databaseStorageService.saveFile(image_cat_id, file, imageDesc, isProfile);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName.getImageName()).toUriString();
		return new Response(image_cat_id, fileName.getImageName(), imageDesc, fileDownloadUri, file.getContentType(),
				file.getSize());
	}

	@PostMapping("/uploadMultipleFiles")
	public List<Response> uploadMultipleFiles(@RequestParam("image_cat_id") Integer image_cat_id,
			@RequestParam("files") MultipartFile[] files, @RequestParam("imageDesc") String imageDesc,
			@RequestParam("isProfile") boolean isProfile) {
		return Arrays.asList(files).stream().map(file -> uploadFile(image_cat_id, file, imageDesc, isProfile))
				.collect(Collectors.toList());
	}

	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		DbImageFile dbImageFile = databaseStorageService.getFile(fileName);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbImageFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbImageFile.getImageName() + "\"")
				.body(new ByteArrayResource(dbImageFile.getData()));
	}

	@GetMapping("/fetch_all_files")
	public List<DbImageFile> getListFiles(Model model) {
		List<DbImageFile> fileDetails = databaseStorageService.getListOfFiles();
		return fileDetails;
	}

	@PostMapping("/addProduct")
	public DbProduct addProduct(@RequestParam("prodcutName") String prodcutName,
			@RequestParam("productPrice") Integer productPrice,
			@RequestParam("productDesc") String productDesc,
			@RequestParam("imageCatId") Integer imageCatId) {
		System.err.println("In FileController -> uploadFile!!!");
		DbProduct response = databaseStorageService.saveProduct(prodcutName, productPrice, productDesc,imageCatId);
		return response;
	}

	@PutMapping("/updateProduct/{productId}")
	public DbProduct updateProduct(@PathVariable("productId") String productId,@RequestParam("prodcutName") String prodcutName,
			@RequestParam("productPrice") Integer productPrice, @RequestParam("productDesc") String productDesc,
			@RequestParam("imageCatId") Integer imageCatId) {
		System.err.println("In FileController -> updateProduct!!!");
		DbProduct response = databaseStorageService.updateProduct(productId,prodcutName, productPrice, productDesc,imageCatId);
		return response;
	}


	@GetMapping("/findByIdProduct/{productId}")
	public DbProduct findByIdProduct(@PathVariable("productId")String productId) {
		System.err.println("In FileController -> findByIdProduct!!!");
		DbProduct response = databaseStorageService.findByIdProduct(productId);
		return response;
	}

	@GetMapping("/findAllProduct") //Here make a DTO and write a to join both table and fetch data
	public List<DbProduct> findAllProduct() {
		System.err.println("In FileController -> findAllProduct!!!");
		List<DbProduct>  response = databaseStorageService.findAllProduct();
		return response;
	}
	
	
	
}