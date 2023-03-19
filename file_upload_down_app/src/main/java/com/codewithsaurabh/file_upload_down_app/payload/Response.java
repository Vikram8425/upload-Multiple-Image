package com.codewithsaurabh.file_upload_down_app.payload;

public class Response {
	private Integer image_cat_id;
	private String fileName;
	private String fileDesc;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public Response(Integer image_cat_id, String fileName,String fileDesc, String fileDownloadUri, String fileType, long size) {
		this.image_cat_id = image_cat_id;	
		this.fileName = fileName;	
		this.fileDesc = fileDesc;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public Integer getImage_cat_id() {
		return image_cat_id;
	}

	public void setImage_cat_id(Integer image_cat_id) {
		this.image_cat_id = image_cat_id;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
