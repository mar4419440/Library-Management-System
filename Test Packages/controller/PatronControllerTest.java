/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Service.PatronService;
import model.Patron;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
public class PatronControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PatronService patronService;

    @Test
    public void testCreatePatron() throws Exception {
        Patron patron = new Patron();
        patron.setPatronName("Test Patron");

        // Perform a POST request to create a patron
        ResultActions resultActions = mockMvc.perform(post("/Patron")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{ \"name\": \"Test Patron\" }"));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the patronService's createPatron method is called
        Mockito.verify(patronService, Mockito.times(1)).createPatron(patron);
    }

    @Test
    public void testUpdatePatron() throws Exception {
        Long patronId = 1L;
        Patron patron = new Patron();
        patron.setPatronId(patronId);
        patron.setPatronName("Updated Test Patron");

        // Perform a PUT request to update a patron
        ResultActions resultActions = mockMvc.perform(put("/Patron")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content("{ \"id\": 1, \"name\": \"Updated Test Patron\" }"));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the patronService's updatePatron method is called
        Mockito.verify(patronService, Mockito.times(1)).UpdatePatron(patron);
    }

    @Test
    public void testDeletePatron() throws Exception {
        Long patronId = 1L;

        // Perform a DELETE request to delete a patron
        ResultActions resultActions = mockMvc.perform(delete("/Patron/{patronId}", patronId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the patronService's deletePatron method is called
        Mockito.verify(patronService, Mockito.times(1)).DeletePatron(patronId);
    }

    @Test
    public void testGetPatron() throws Exception {
        Long patronId = 1L;
        Patron patron = new Patron();
        patron.setPatronId(patronId);
        patron.setPatronName("Test Patron");

        Mockito.when(patronService.getPatron(patronId)).thenReturn(patron);

        // Perform a GET request to retrieve a patron
        ResultActions resultActions = mockMvc.perform(get("/Patron/{patronId}", patronId)
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$.id").value(patronId))
                     .andExpect(jsonPath("$.name").value("Test Patron"));
    }

     @Test
    public void testGetAllPatrons() throws Exception {
        // Perform a GET request to retrieve all patrons
        ResultActions resultActions = mockMvc.perform(get("/Patron")
                                    .contentType(MediaType.APPLICATION_JSON));

        // Verify that the response status is OK (200)
        resultActions.andExpect(status().isOk());

        // Verify that the patronService's getAllPatrons method is called
        Mockito.verify(patronService, Mockito.times(1)).getAllPatron();
    }
}
