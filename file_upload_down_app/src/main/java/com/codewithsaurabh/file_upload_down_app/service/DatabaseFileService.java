package com.codewithsaurabh.file_upload_down_app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.codewithsaurabh.file_upload_down_app.exception.FileNotFoundException;
import com.codewithsaurabh.file_upload_down_app.exception.FileStorageException;
import com.codewithsaurabh.file_upload_down_app.exception.ProductException;
import com.codewithsaurabh.file_upload_down_app.model.DbImageFile;
import com.codewithsaurabh.file_upload_down_app.model.DbProduct;
import com.codewithsaurabh.file_upload_down_app.repository.DatabaseFileRepository;
import com.codewithsaurabh.file_upload_down_app.repository.DatabaseProductRepository;

@Service
public class DatabaseFileService {
	@Autowired
	private DatabaseFileRepository dbFileRepository;
	@Autowired
	DatabaseProductRepository databaseProductRepository;

	public DbImageFile saveFile(Integer image_cat_id, MultipartFile file, String imageDesc, boolean isProfile) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			DbImageFile dbFile = new DbImageFile(image_cat_id, fileName, "imageDesc", isProfile, file.getContentType(),
					file.getBytes());
			return dbFileRepository.save(dbFile);
		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public DbImageFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new FileNotFoundException("File not found with id " + fileId));
	}

	public List<DbImageFile> getListOfFiles() {
		return dbFileRepository.findAll();
	}
	

	public DbProduct saveProduct(String prodcutName, Integer productPrice, String productDesc, Integer imageCatId) {
		if(prodcutName == null || prodcutName == "") {
			throw new ProductException("Sorry! prodcut_name doesn't null or Blank.");
		} else if (productPrice == null || productPrice == 0) {
			throw new ProductException("Sorry! product_price doesn't null or Zero.");
		}
		DbProduct dbProduct = new DbProduct(prodcutName, productPrice, productDesc, imageCatId);
		return databaseProductRepository.save(dbProduct);
	}

 
	public DbProduct updateProduct(String productId, String prodcutName, Integer productPrice, String productDesc,Integer imageCatId) {
		DbProduct dbProduct = this.databaseProductRepository.findById(productId).orElseThrow();
		dbProduct.setProdcutName(prodcutName);
		dbProduct.setProductPrice(productPrice);
		dbProduct.setProductDesc(productDesc);
		dbProduct.setImageCatId(imageCatId);
		return this.databaseProductRepository.save(dbProduct);
	}

	public DbProduct findByIdProduct(String productId) {
		DbProduct dbProduct = this.databaseProductRepository.findById(productId).orElseThrow();
		return dbProduct;
	}

	public List<DbProduct> findAllProduct() {
		return this.databaseProductRepository.findAll();
	}

	 
}
