package com.codewithsaurabh.file_upload_down_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithsaurabh.file_upload_down_app.model.DbImageFile;
import com.codewithsaurabh.file_upload_down_app.model.DbProduct;


@Repository
public interface DatabaseFileRepository extends JpaRepository<DbImageFile, String> {

}