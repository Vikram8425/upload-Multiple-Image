package com.codewithsaurabh.file_upload_down_app.exception;

public class ProductException extends RuntimeException {
    public ProductException(String message) {
        super(message);
    	 System.err.println("In ProductException -> FileStorageException ->  super(message)!!!");
    }

    public ProductException(String message, Throwable cause) {
        super(message, cause);
        System.err.println("In ProductException -> FileStorageException ->  super(message, cause)!!!");
    }

}
