package com.basiccrud.eg.demo.fileHelper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="E:\\Practise\\BackEnd\\Git" +
            "\\SpingbootAPI\\src\\main\\resources\\static\\image";

    public boolean uploadFile(MultipartFile multipartFile){

        boolean f=false;
        try{

           /* InputStream inputStream=multipartFile.getInputStream();
            byte data[]=new byte[inputStream.available()];
            inputStream.read();

            //writing on upload_dir

            FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
            // OR--> FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
            fos.write(data);
            fos.flush();
            fos.close();*/

            // alternative method
            //Files.copy(input stream,target--> path of file where you want to write the file,to replace it or not)
            Files.copy(multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);

            return f=true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

}
