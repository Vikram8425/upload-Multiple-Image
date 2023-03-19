package com.codewithsaurabh.file_upload_down_app.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "image1")
public class DbImageFile {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String imageId;
	private Integer image_cat_id;
	private String imageName;
	private String imageDesc;
	private boolean isProfile;
	private String fileType;
	@Lob
	private byte[] data;

	public DbImageFile() {
		super();
	}

	public DbImageFile(Integer image_cat_id, String imageName, String imageDesc, boolean isProfile,
			String fileType, byte[] data) {
		super();
		this.image_cat_id = image_cat_id;
		this.imageName = imageName;
		this.imageDesc = imageDesc;
		this.isProfile = isProfile;
		this.fileType = fileType;
		this.data = data;
	}

	public Integer getImage_cat_id() {
		return image_cat_id;
	}

	public void setImage_cat_id(Integer image_cat_id) {
		this.image_cat_id = image_cat_id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageDesc() {
		return imageDesc;
	}

	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}

	public boolean isProfile() {
		return isProfile;
	}

	public void setProfile(boolean isProfile) {
		this.isProfile = isProfile;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	 

}
