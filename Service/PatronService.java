/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.Patron;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public interface PatronService {
     public void createPatron(Patron patron);
    public void UpdatePatron(Patron patron);
    public void DeletePatron(Long patronId);
    public Patron getPatron(Long patronId);
    public List<Patron > getAllPatron();
}
