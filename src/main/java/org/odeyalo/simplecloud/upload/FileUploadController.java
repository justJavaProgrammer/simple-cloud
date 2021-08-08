package org.odeyalo.simplecloud.upload;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

@Controller
@RequestMapping("simple-cloud/upload")
public class FileUploadController {

    @Qualifier("fileUploadService")
    private final UploadService service;

    public FileUploadController(UploadService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String main(Model model) {
        return "UploadFile";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String upload(Model model, @RequestParam("files")MultipartFile[] files) {
        final boolean isSuccess = service.upload(model, files);
        return isSuccess ? "Successful" : "errors/Error";
    }
}
