package com.toostew.file_scanner;


import fi.solita.clamav.ClamAVClient;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;
import tools.jackson.databind.json.JsonMapper;

@RestController
public class controllerHandler {

    private JsonMapper jsonMapper;
    private S3Client s3Client;
    private ClamAVClient clamAVClient;

    public controllerHandler(JsonMapper jsonMapper, S3Client s3Client,ClamAVClient clamAVClient) {
        this.jsonMapper = jsonMapper;
        this.s3Client = s3Client;
        this.clamAVClient = clamAVClient;
    }




}
