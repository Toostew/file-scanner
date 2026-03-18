package com.toostew.file_scanner.config;


import fi.solita.clamav.ClamAVClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClamAVConfig {

    @Value("${clamAV.URI}")
    private String clamAVURI;

    @Value("${clamAV.Port}")
    private int clamAVPort;


    //this client will be used to communicate with the clamAV daemon in its container
    @Bean
    public ClamAVClient generateClamAVClient() {
        ClamAVClient AVClient = new ClamAVClient(clamAVURI,clamAVPort);

        return AVClient;
    }

}
