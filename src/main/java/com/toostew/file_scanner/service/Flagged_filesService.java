package com.toostew.file_scanner.service;


import com.toostew.file_scanner.DAO.impl.Flagged_filesDAO;
import com.toostew.file_scanner.entity.Flagged_files;
import com.toostew.file_scanner.exceptions.DAO.DAOException;
import com.toostew.file_scanner.exceptions.DAOServiceException;
import org.springframework.stereotype.Service;

@Service
public class Flagged_filesService {

    private Flagged_filesDAO flagged_filesDAO;

    public Flagged_filesService(Flagged_filesDAO flagged_filesDAO) {
        this.flagged_filesDAO = flagged_filesDAO;
    }


    public void createFlagged_files(Flagged_files flagged_files) {
        try{
            flagged_filesDAO.create(flagged_files);
        } catch (DAOException e){
            throw new DAOServiceException("Flagged_files Service: createFlagged_files failed", e);
        }
    }

    public Flagged_files getFlagged_files(int id) {
        try{
            return flagged_filesDAO.get(id);
        } catch (DAOException e){
            throw new DAOServiceException("Flagged_files Service: getFlagged_files failed", e);
        }
    }

    public void updateFlagged_files(Flagged_files flagged_files) {
        try{
            flagged_filesDAO.update(flagged_files);
        } catch (DAOException e){
            throw new DAOServiceException("Flagged_files Service: updateFlagged_files failed", e);
        }
    }

    public void deleteFlagged_files(int id) {
        try{
            flagged_filesDAO.delete(id);
        } catch (DAOException e){
            throw new DAOServiceException("Flagged_files Service: deleteFlagged_files failed", e);
        }
    }

}
