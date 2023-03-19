package com.codewithsaurabh.file_upload_down_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsaurabh.file_upload_down_app.model.DbProduct;

public interface DatabaseProductRepository extends JpaRepository<DbProduct,String>{

}
