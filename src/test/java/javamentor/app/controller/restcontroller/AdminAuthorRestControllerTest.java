package javamentor.app.controller.restcontroller;

import javamentor.app.controller.restController.AdminAuthorRestController;
import javamentor.app.model.Author;
import javamentor.app.service.abstraction.AuthorService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * unit test для контроллера
 */
public class AdminAuthorRestControllerTest {

    @InjectMocks
    AdminAuthorRestController controller;

    @Mock
    AuthorService authorService;

    private Author author1, author2, authorFind;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        author1 = new Author(1L, "Eminem");
        author2 = new Author(2L, "Leonard Cohen");
    }

    @Test
    public void getAllAuthor() {
        //init
        when(authorService.getAllAuthor()).thenReturn(Arrays.asList(author1, author2));
        //use
        List<Author> authors = controller.getAllAuthor();
        //check
        assertTrue(authors.size() == 2);
        verify(authorService, times(1)).getAllAuthor();
        verifyNoMoreInteractions(authorService);
    }

    @Test
    public void getByIdAuthor() {
        //init
        when(authorService.getById(anyLong())).thenReturn(author1);
        //use
        authorFind = controller.getByIdAuthor(1L);
        //check
        assertNotNull(authorFind);
        assertEquals(authorFind, author1);
        verify(authorService, times(1)).getById(anyLong());
        verifyNoMoreInteractions(authorService);
    }

    @Test
    public void addAuthor() {
        //init
       when(authorService.getByName(author1.getName())).thenReturn(null);
        //use
        controller.addAuthor(author1);
        //check
    }

    @Test
    public void deleteAuthor() {
        //init
        doNothing().when(authorService).deleteAuthorById(anyLong());
        //use
        controller.deleteAuthor(1L);
        //check
        verify(authorService, times(1)).deleteAuthorById(anyLong());
        verifyNoMoreInteractions(authorService);
    }
}