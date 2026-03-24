package com.toostew.file_scanner.service;


import com.toostew.file_scanner.DAO.impl.File_recordsDAO;
import com.toostew.file_scanner.entity.File_records;
import com.toostew.file_scanner.exceptions.DAO.DAOException;
import com.toostew.file_scanner.exceptions.DAOServiceException;
import org.springframework.stereotype.Service;

@Service
public class File_recordsService {

    private File_recordsDAO file_recordsDAO;

    public File_recordsService(File_recordsDAO file_recordsDAO) {
        this.file_recordsDAO = file_recordsDAO;
    }

    public void createFile_records(File_records file_records) {
        try {
            file_recordsDAO.create(file_records);
        } catch (DAOException e) {
            throw new DAOServiceException("createFile_records: createFile_records failed", e);
        }
    }

    public File_records getFile_records(int id) {
        try {
            return file_recordsDAO.get(id);
        } catch (DAOException e) {
            throw new DAOServiceException("getFile_records: getFile_records failed", e);
        }
    }

    public void updateFile_records(File_records file_records) {
        try {
            file_recordsDAO.update(file_records);
        } catch (DAOException e) {
            throw new DAOServiceException("updateFile_records: updateFile_records failed", e);
        }
    }

    public void deleteFile_records(int id) {
        try {
            file_recordsDAO.delete(id);
        } catch (DAOException e) {
            throw new DAOServiceException("deleteFile_records: deleteFile_records failed", e);
        }
    }

}
