package com.codewithsaurabh.file_upload_down_app.exception;
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    	 System.err.println("In FileStorageException -> FileStorageException ->  super(message)!!!");
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
        System.err.println("In FileStorageException -> FileStorageException ->  super(message, cause)!!!");
    }
}