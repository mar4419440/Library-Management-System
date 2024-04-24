package Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import Repository.PatronRepository;
import exception.PatronCreateException;
import exception.PatronDeleteException;
import exception.PatronNotFoundException;
import exception.PatronUpdateException;
import model.Patron;
import Service.ServiceImpl.PatronServiceImpl;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PatronServiceImplTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronServiceImpl patronService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePatron() {
        Patron patron = new Patron();
        patron.setPatronId(1L);
        patron.setPatronName("mahmoud ahmed");

        Mockito.when(patronRepository.save(patron)).thenReturn(patron);

        assertDoesNotThrow(() -> patronService.createPatron(patron));

        Mockito.verify(patronRepository, Mockito.times(1)).save(patron);
    }

    @Test
    void testUpdatePatron() {
        Patron patron = new Patron();
        patron.setPatronId(1L);
        patron.setPatronName("mahmoud ahmed");

        Mockito.when(patronRepository.save(patron)).thenReturn(patron);

        assertDoesNotThrow(() -> patronService.UpdatePatron(patron));

        Mockito.verify(patronRepository, Mockito.times(1)).save(patron);
    }

    @Test
    void testDeletePatron() {
        Long patronId = 1L;

        Mockito.doNothing().when(patronRepository).deleteById(patronId);

        assertDoesNotThrow(() -> patronService.DeletePatron(patronId));

        Mockito.verify(patronRepository, Mockito.times(1)).deleteById(patronId);
    }

    @Test
    void testGetPatron() {
        Long patronId = 1L;
        Patron patron = new Patron();
        patron.setPatronId(patronId);
        patron.setPatronName("Mahmoud ahmed");

        Mockito.when(patronRepository.findById(patronId)).thenReturn(Optional.of(patron));

        assertDoesNotThrow(() -> patronService.getPatron(patronId));

        Mockito.verify(patronRepository, Mockito.times(1)).findById(patronId);
    }

    @Test
    void testGetPatronNotFound() {
        Long patronId = 1L;

        Mockito.when(patronRepository.findById(patronId)).thenReturn(Optional.empty());

        assertThrows(PatronNotFoundException.class, () -> patronService.getPatron(patronId));

        Mockito.verify(patronRepository, Mockito.times(1)).findById(patronId);
    }

    @Test
    void testGetAllPatron() {
        List<Patron> patrons = new ArrayList<>();
        patrons.add(new Patron());
        patrons.add(new Patron());
        patrons.add(new Patron());

        Mockito.when(patronRepository.findAll()).thenReturn(patrons);

        assertEquals(patrons.size(), patronService.getAllPatron().size());

        Mockito.verify(patronRepository, Mockito.times(1)).findAll();
    }
}
