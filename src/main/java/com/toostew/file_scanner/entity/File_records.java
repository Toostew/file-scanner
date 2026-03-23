package com.toostew.file_scanner.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class File_records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "original_name")
    private String original_name;

    @Column(name = "stored_name")
    private String stored_name;

    @Column(name = "content_type")
    private String content_type;

    @Column(name = "size")
    private long size;

    @Column(name = "storage_path")
    private String storage_path; //this is the bucket name



    @Column(name = "user_id")
    private int user_id;

    @Column(name = "date_created")
    private LocalDate date_created;

    @Column(name = "viewable")
    private boolean viewable;


    @Column(name = "course_id")
    private int course_id;

    //limited to 25 characters
    @Column(name = "verified")
    private String verified;


    public File_records() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getStorage_path() {
        return storage_path;
    }

    public void setStorage_path(String storage_path) {
        this.storage_path = storage_path;
    }



    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public boolean getViewable() {
        return viewable;
    }

    public void setViewable(boolean viewable) {
        this.viewable = viewable;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isViewable() {
        return viewable;
    }

    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getVerified() {
        return verified;
    }
    public void setVerified(String verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "FILE: " + "\n"
                + "id: " + id + "\n"
                + "original_name: " + original_name + "\n"
                + "stored_name: " + stored_name + "\n"
                + "content_type: " + content_type + "\n"
                + "size: " + size + "\n"
                + "storage_path: " + storage_path + "\n"
                + "user_id: " + getUser_id() + "\n"
                + "date_created: " + date_created + "\n"
                + "course_id: " + getCourse_id() + "\n";
    }

}
