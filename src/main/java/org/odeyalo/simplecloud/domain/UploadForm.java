package org.odeyalo.simplecloud.domain;

import org.odeyalo.simplecloud.user.User;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.Arrays;

public class UploadForm {
    private String fileName;
    private MultipartFile file;
    private MultipartFile[] files;
    private long fileSize;
    private URL downloadPath;
    private User user;

    public UploadForm(String fileName, MultipartFile file, long fileSize, URL downloadPath, User user) {
        this.fileName = fileName;
        this.file = file;
        this.fileSize = fileSize;
        this.downloadPath = downloadPath;
        this.user = user;
    }

    public UploadForm(String fileName, MultipartFile[] files, long fileSize, URL downloadPath, User user) {
        this.fileName = fileName;
        this.files = files;
        this.fileSize = fileSize;
        this.downloadPath = downloadPath;
        this.user = user;
    }

    public UploadForm() {

    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

    public void setFiles(MultipartFile[] files) {
        this.files = files;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public URL getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(URL downloadPath) {
        this.downloadPath = downloadPath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UploadForm{" +
                "fileName='" + fileName + '\'' +
                ", file=" + file +
                ", files=" + Arrays.toString(files) +
                ", fileSize=" + fileSize +
                ", downloadPath=" + downloadPath +
                ", user=" + user +
                '}';
    }
}
