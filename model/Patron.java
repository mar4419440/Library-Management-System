/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name="Patron_Details")
public class Patron {
     @Id
    private Long patronId;
    
    
    private String patronName;
    
    private String patronContact;
    
    private String patronInfo;

    public Patron() {
        // Default constructor for JPA compliance
    }

    public Patron(Long patronId, String patronName, String patronContact, String patronInfo) {
        this.patronId = patronId;
        this.patronName = patronName;
        this.patronContact = patronContact;
        this.patronInfo = patronInfo;
    }


    public Long getPatronID() {
        return this.patronId;
    }

    public void setPatronID(Long PatronID) {
        this.patronId = PatronID;
    }

    public Long getPatronId() {
        return patronId;
    }

    public void setPatronId(Long patronId) {
        this.patronId = patronId;
    }

    public String getPatronName() {
        return patronName;
    }

    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    public String getPatronContact() {
        return patronContact;
    }

    public void setPatronContact(String patronContact) {
        this.patronContact = patronContact;
    }

    public String getPatronInfo() {
        return patronInfo;
    }

    public void setPatronInfo(String patronInfo) {
        this.patronInfo = patronInfo;
    }

  
    
}
