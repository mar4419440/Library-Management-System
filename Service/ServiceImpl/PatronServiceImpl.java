/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.ServiceImpl;

import Repository.PatronRepository;
import Service.PatronService;
import exception.PatronCreateException;
import exception.PatronDeleteException;
import exception.PatronNotFoundException;
import exception.PatronUpdateException;
import java.util.List;
import model.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ADMIN
 */
@Service
public class PatronServiceImpl implements PatronService{
    PatronRepository patronRepository;
    
    @Autowired
    public PatronServiceImpl(PatronRepository patronRepository) {
        this.patronRepository = patronRepository;
    }
    
    @Override
    public void createPatron(Patron patron) {
       try {
            patronRepository.save(patron);
        } catch (Exception e) {
            throw new PatronCreateException("Failed to create patron", e);
        }
    }

    @Override
    public void UpdatePatron(Patron patron) {
        try {
            patronRepository.save(patron);
        } catch (Exception e) {
            throw new PatronUpdateException("Failed to update patron", e);
        }
    }

    @Override
    public void DeletePatron(Long patronId) {
         try {
            patronRepository.deleteById(patronId);
        } catch (Exception e) {
            throw new PatronDeleteException("Failed to delete patron", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Patron getPatron(Long patronId) {
        return patronRepository.findById(patronId)
                                .orElseThrow(() -> new PatronNotFoundException("Patron not found with ID: " + patronId)); 
    }

    @Override
    @Transactional(readOnly = true)
    public List<Patron> getAllPatron() {
        return patronRepository.findAll(); 
    }
    
}
