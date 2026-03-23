package com.toostew.file_scanner.DAO.impl;

import com.toostew.file_scanner.DAO.GenericDAO;
import com.toostew.file_scanner.entity.File_records;
import com.toostew.file_scanner.entity.Flagged_files;
import com.toostew.file_scanner.exceptions.DAO.DAOException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class Flagged_filesDAO implements GenericDAO<Flagged_files> {

    private EntityManager em;

    public Flagged_filesDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Flagged_files flaggedFiles) {
        try {
            em.persist(flaggedFiles);
        } catch (EntityExistsException e) {
            throw new DAOException("Flagged_filesDAO: entry already exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("Flagged_filesDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("Flagged_filesDAO: unknown issue", e);
        }
    }

    @Override
    public Flagged_files get(int id) {
        try {
            return em.find(Flagged_files.class, id);
        } catch (EntityNotFoundException e) {
            throw new DAOException("Flagged_filesDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("Flagged_filesDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("Flagged_filesDAO: unknown issue", e);
        }
    }

    @Override
    public void update(Flagged_files flaggedFiles) {
        try {
            Flagged_files temp = em.find(Flagged_files.class, flaggedFiles.getId());
            temp.setDetection_date(flaggedFiles.getDetection_date());
            temp.setFile_records(flaggedFiles.getFile_records());
            temp.setEicar_signature(flaggedFiles.getEicar_signature());

        } catch (EntityNotFoundException e) {
            throw new DAOException("Flagged_filesDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("Flagged_filesDAO: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("Flagged_filesDAO: unknown issue", e);
        }
    }

    @Override
    public void delete(int id) {
        try {
            Flagged_files temp = em.find(Flagged_files.class, id);
            em.remove(temp);
        } catch (EntityNotFoundException e) {
            throw new DAOException("Flagged_filesDAO: entry doesn't exists", e);
        } catch (IllegalStateException e) {
            throw new DAOException("Flagged_filesDAO:: Illegal state", e); // i guess bro
        } catch (Exception e) {
            throw new DAOException("Flagged_filesDAO: unknown issue", e);
        }
    }
}
