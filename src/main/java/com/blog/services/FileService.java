package com.blog.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	String uploadImage(String path, MultipartFile file) throws IOException;

    // to serve the image (show on webpage)
    InputStream getResource(String path, String fileName) throws FileNotFoundException;
}
