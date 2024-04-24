/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Library.mangment.Sysytem.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Repository.PatronRepository;
import Service.ServiceImpl.PatronServiceImpl;
import model.Patron;

@ExtendWith(MockitoExtension.class)
public class PatronRepositoryTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronServiceImpl patronService;

    @Test
    void testFindById() {
        // Create a mock Patron object
        Patron mockPatron = new Patron();
        mockPatron.setPatronId(1L);
        mockPatron.setPatronName("mahmoud ahmed");

        // Mock the findById method of the repository to return the mock Patron object
        when(patronRepository.findById(1L)).thenReturn(Optional.of(mockPatron));

        // Call the service method that uses the repository method
        Patron foundPatron = patronService.getPatron(1L);

        // Verify that the service method returns the expected Patron object
        assertEquals("John Doe", foundPatron.getPatronName());
    }

    // Add more test methods for other repository methods as needed
}

