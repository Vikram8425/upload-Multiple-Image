package com.codewithsaurabh.file_upload_down_app.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class DbProduct {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String productId;
	private String prodcutName;
	private Integer productPrice;
	private String productDesc;
	private Integer imageCatId;
	public DbProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DbProduct(String prodcutName, Integer productPrice, String productDesc, Integer imageCatId) {
		super();
		this.prodcutName = prodcutName;
		this.productPrice = productPrice;
		this.productDesc = productDesc;
		this.imageCatId = imageCatId;
	}
	public String getProdcutName() {
		return prodcutName;
	}
	public void setProdcutName(String prodcutName) {
		this.prodcutName = prodcutName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public Integer getImageCatId() {
		return imageCatId;
	}
	public void setImageCatId(Integer imageCatId) {
		this.imageCatId = imageCatId;
	}
	 
}
