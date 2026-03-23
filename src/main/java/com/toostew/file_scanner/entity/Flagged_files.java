package com.toostew.file_scanner.entity;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Flagged_files {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_records_id") //joincolumn refers to the name of the column in mysql
    private File_records file_records;

    @Column(name = "eicar_signature")
    private String eicar_signature;

    @Column(name = "detection_date")
    private Instant detection_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public File_records getFile_records() {
        return file_records;
    }

    public void setFile_records(File_records file_records) {
        this.file_records = file_records;
    }

    public String getEicar_signature() {
        return eicar_signature;
    }

    public void setEicar_signature(String eicar_signature) {
        this.eicar_signature = eicar_signature;
    }

    public Instant getDetection_date() {
        return detection_date;
    }

    public void setDetection_date(Instant detection_date) {
        this.detection_date = detection_date;
    }
}
