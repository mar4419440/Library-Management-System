/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.PatronService;
import java.util.List;
import model.Patron;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/Patron")
@Validated
public class PatronController {
    private final PatronService patronService;

    public PatronController(PatronService patronService) {
        this.patronService = patronService;
    }
    
    @PostMapping
    public void CreatePatron(@RequestBody Patron patron){
        patronService.createPatron(patron);
    }
    
    @PutMapping
    public void UpdatePatron(@RequestBody Patron patron){
        patronService.UpdatePatron(patron);
    }
    
    @DeleteMapping("{patronId}")
    public void DeletePatron(@PathVariable("patronId")long patronId){
        patronService.DeletePatron(patronId);
    }
    @GetMapping("{patronId}")
    public Patron getPatron(@PathVariable("patronId") long patronid){
        return patronService.getPatron(patronid);
    }
    @GetMapping
    public List<Patron> getAllPatron(){
        return patronService.getAllPatron();
    }
}
