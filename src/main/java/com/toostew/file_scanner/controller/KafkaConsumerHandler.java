package com.toostew.file_scanner.controller;


import com.toostew.file_scanner.exceptions.ControllerHandlerException;
import com.toostew.file_scanner.pojo.ProcessRequest;
import com.toostew.file_scanner.service.R2Service;
import fi.solita.clamav.ClamAVClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.nio.charset.StandardCharsets;

@Component
public class KafkaConsumerHandler {

    @Value("kafka.filescan.topic")
    private String fileScanTopic;

    private R2Service r2Service;
    private ClamAVClient clamAVClient;

    public KafkaConsumerHandler(R2Service r2Service, ClamAVClient clamAVClient) {
        this.r2Service = r2Service;
        this.clamAVClient = clamAVClient;
    }


    //for some reason the topic cant be injected so i need to hardcode it in
    @KafkaListener(id = "kafka-filescane-consumer", topics = "verify-file")
    public void scanFiles(ProcessRequest processRequest) {
        BufferedInputStream tempStream = r2Service.getObjectFromR2AsBufferedInputStream(processRequest.getStored_name());

        byte[] reply;
        try {
            reply = clamAVClient.scan(tempStream);
        } catch (Exception e) {
            throw new ControllerHandlerException("Could not scan the input", e);
        }
        String str = new String(reply, StandardCharsets.UTF_8);

        if (ClamAVClient.isCleanReply(reply)) {
            //clean, no issues
            System.out.println("Scan complete for " +  processRequest.getStored_name() + ", no issues");

            //make file viewable, change unverified to verified




        } else {
            //threat detected
            System.out.println("Scan for " +  processRequest.getStored_name() + " detected: " + str);


            //file (should) remain unviewable, but to be sure just set it unviewable anyway
            //change unverified to flagged, move to quarantine bucket
        }
    }

}
