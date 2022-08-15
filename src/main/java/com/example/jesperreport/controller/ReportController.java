package com.example.jesperreport.controller;

import com.example.jesperreport.service.JesperService;
import com.example.jesperreport.service.model.LendingFileForm;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ReportController {

	@Autowired
	JesperService jesperService;

	@PostMapping("jesper/gen_lend_pdf")
	public ResponseEntity jesperGenerateLendPdfController(@RequestBody List<LendingFileForm> fileForm) throws DocumentException, IOException{
		return jesperService.genJesperLendingPDF(fileForm);
//		return "Jesper Lending File created";
	}
}
