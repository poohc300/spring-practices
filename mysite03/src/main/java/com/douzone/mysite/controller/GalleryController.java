package com.douzone.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.service.FileUploadService;
import com.douzone.mysite.service.GalleryService;
import com.douzone.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private FileUploadService fileUploadService;
	
	@Autowired
	private GalleryService galleryService;

	@RequestMapping("")
	public String index() {
		return "gallery/index";
	}
	
	@RequestMapping("upload")
	public String fileUpload(@RequestParam("file") MultipartFile multipartFile) {
		System.out.println(multipartFile.getName());
		String url = fileUploadService.restore(multipartFile);
		
		return "redirect:/gallery";
	}
	
}
