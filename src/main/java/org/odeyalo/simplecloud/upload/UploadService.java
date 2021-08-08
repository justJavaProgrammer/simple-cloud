package org.odeyalo.simplecloud.upload;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    boolean upload(Model model, MultipartFile[] files);
}
