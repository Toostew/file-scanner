package com.toostew.file_scanner.pojo;

public class FileToScanRequest {

    private int file_records_id;

    private String stored_name;

    private String content_type;



    public int getFile_records_id() {
        return file_records_id;
    }
    public void setFile_records_id(int file_records_id) {
        this.file_records_id = file_records_id;
    }


    public String getStored_name() {
        return stored_name;
    }
    public void setStored_name(String stored_name) {
        this.stored_name = stored_name;
    }


    public String getContent_type() {
        return content_type;
    }
    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }
}
