package org.odeyalo.simplecloud.upload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

@Service
@PropertySource("classpath:path.properties")
public class FileUploadService implements UploadService {
    @Value("${path.fullPath}")
    private String fullPath;


    @Override
    public boolean upload(Model model, MultipartFile[] files) {
        for (MultipartFile file : files) {
            try {
                String original = file.getOriginalFilename();
                final String path = fullPath + original;
                file.transferTo(Paths.get(path));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
