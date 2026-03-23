package com.toostew.file_scanner.DAO.impl;

import com.toostew.file_scanner.DAO.GenericDAO;
import com.toostew.file_scanner.entity.File_records;
import com.toostew.file_scanner.exceptions.DAO.DAOException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;


@Repository
public class File_recordsDAO implements GenericDAO<File_records> {

    private EntityManager em;

    public File_recordsDAO(EntityManager em) {
        this.em = em;
    }


    @Override
    public void create(File_records fileRecords) {
        try {
            em.persist(fileRecords);
        } catch (EntityExistsException e) {
            throw new DAOException("File_recordsDAO: entry already exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("File_recordsDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("File_recordsDAO: unknown issue", e);
        }

    }

    @Override
    public File_records get(int id) {
        try {
            return em.find(File_records.class, id);
        } catch (EntityNotFoundException e) {
            throw new DAOException("File_recordsDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("File_recordsDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("File_recordsDAO: unknown issue", e);
        }
    }

    @Override
    public void update(File_records fileRecords) {
        try {
            File_records temp = em.find(File_records.class, fileRecords.getId());
            temp.setOriginal_name(fileRecords.getOriginal_name());
            temp.setStorage_path(fileRecords.getStorage_path());
            temp.setStored_name(fileRecords.getStored_name());
            temp.setVerified(fileRecords.getVerified());
            temp.setViewable(fileRecords.getViewable());
            em.merge(temp);
        } catch (EntityNotFoundException e) {
            throw new DAOException("File_recordsDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("File_recordsDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("File_recordsDAO: unknown issue", e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            File_records temp = em.find(File_records.class, id);
            em.remove(temp);
        } catch (EntityNotFoundException e) {
            throw new DAOException("File_recordsDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("File_recordsDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("File_recordsDAO: unknown issue", e);
        }
    }
}
