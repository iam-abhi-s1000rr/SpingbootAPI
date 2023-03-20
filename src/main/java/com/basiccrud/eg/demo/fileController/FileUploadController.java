package com.basiccrud.eg.demo.fileController;

import com.basiccrud.eg.demo.fileHelper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private FileUploadHelper fileUploadHelper;
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile file){
       try{

           if(file.isEmpty()){
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please insert a file");
           }

           if(!file.getContentType().equals("image/jpeg")){
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Please insert only jpeg file");
           }

       }catch(Exception e){
           e.printStackTrace();
       }
       boolean f=fileUploadHelper.uploadFile(file);
       if(f){
           return ResponseEntity.ok("File is Successfully uploaded !");
       }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong !! Try again !!!!");
    }
}
