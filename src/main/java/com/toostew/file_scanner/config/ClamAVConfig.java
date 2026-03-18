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

        //set the Client timeout to 10,000 ms, so clamAV has 10 seconds to process
        //clamAV needs time to load its data into memory so we give it ample time
        //TODO: ideally, we should ping instead do a simple ping to the server before
        // sending content. Expanding on this a health checker that periodically pings
        ClamAVClient AVClient = new ClamAVClient(clamAVURI,clamAVPort,10000);

        return AVClient;
    }

}
