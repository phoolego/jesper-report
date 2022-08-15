package com.example.jesperreport.service;

import com.example.jesperreport.service.model.LendingFileForm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class JesperService {
    private static final String TEMPLATE_FOLDER = "/form-templates";
    private static final String EXPORT_FOLDER = "./export-document";
    private static final String JESPER_LENDING_TEMPLATE_NAME = "jesper-lending-template";


    public ResponseEntity genJesperLendingPDF(List<LendingFileForm> fileFormList){
        try{
            InputStream stream = getClass().getResourceAsStream(getTemplatePath(JESPER_LENDING_TEMPLATE_NAME));
            JasperReport jasperReport = JasperCompileManager.compileReport(stream);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(fileFormList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            //Export to file and save
            JasperExportManager.exportReportToPdfFile(jasperPrint, getPDFExportPath("lending-application"));
            //Export to byte for response
            byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION,"inline:filename=lending-application.pdf");
            return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
        } catch (JRException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    private String getTemplatePath(String templateFile){
        return TEMPLATE_FOLDER+"/"+templateFile+".jrxml";
    }
    private String getPDFExportPath(String fileName){
        return EXPORT_FOLDER+"/"+fileName+".pdf";
    }
}
