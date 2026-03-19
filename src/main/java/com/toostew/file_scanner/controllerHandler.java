package com.toostew.file_scanner;


import com.toostew.file_scanner.exceptions.ControllerHandlerException;
import com.toostew.file_scanner.pojo.FileToScanRequest;
import com.toostew.file_scanner.service.R2Service;
import fi.solita.clamav.ClamAVClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.s3.S3Client;
import tools.jackson.databind.json.JsonMapper;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class controllerHandler {

    private JsonMapper jsonMapper;
    private R2Service r2Service;
    private ClamAVClient clamAVClient;

    public controllerHandler(JsonMapper jsonMapper,ClamAVClient clamAVClient,
                             R2Service r2Service) {

        this.jsonMapper = jsonMapper;
        this.clamAVClient = clamAVClient;
        this.r2Service = r2Service;
    }



    @GetMapping("/scan")
    public void scan(@RequestBody FileToScanRequest fileToScanRequest) {
        BufferedInputStream tempStream = r2Service.getObjectFromR2AsBufferedInputStream(fileToScanRequest.getStored_name());

        byte[] reply;
        try {
            reply = clamAVClient.scan(tempStream);
        } catch (Exception e) {
            throw new ControllerHandlerException("Could not scan the input", e);
        }
        String str = new String(reply, StandardCharsets.UTF_8);
        if (ClamAVClient.isCleanReply(reply)) {
            System.out.println("Scan successful!");
            System.out.println(str);
        } else {
            System.out.println("virus detected!");
            System.out.println(str);
        }

    }




}
