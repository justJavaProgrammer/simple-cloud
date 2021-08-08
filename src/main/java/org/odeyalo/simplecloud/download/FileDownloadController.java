package org.odeyalo.simplecloud.download;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("simple-cloud/download")
@PropertySource("classpath:path.properties")
public class FileDownloadController {

    @Value("${path.fullPath}")
    private String path;
    @RequestMapping("/file/{fileName:.+}")
    public void downloadResource( HttpServletRequest request,
                                     HttpServletResponse response,
                                     @PathVariable("fileName") String fileName)
    {
        //If user is not authorized - he should be thrown out from here itself
        System.out.println(fileName);
        //Authorized user will download the file
        //String dataDirectory = request.getServletContext().getRealPath("/static/");
        Path file = Paths.get(path, fileName);
        if (Files.exists(file)) {
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            try {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}