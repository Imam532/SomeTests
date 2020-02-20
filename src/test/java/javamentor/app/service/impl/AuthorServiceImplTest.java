package javamentor.app.service.impl;

import javamentor.app.dao.abstraction.AuthorDao;
import javamentor.app.model.Author;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * unit test для сервис-слоя
 */
public class AuthorServiceImplTest {

    @InjectMocks
    AuthorServiceImpl authorService;

    @Mock
    AuthorDao authorDao;

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
        when(authorDao.getAll()).thenReturn(Arrays.asList(author1, author2));
        //use
        List<Author> authors = authorService.getAllAuthor();
        //check
        assertTrue(authors.size() == 2);
        verify(authorDao, atLeastOnce()).getAll();
        verifyNoMoreInteractions(authorDao);

    }

    @Test
    public void test_getByName_ok() {
        //init
        when(authorDao.getByName(anyString())).thenReturn(author1);
        //use
        authorFind =  authorService.getByName("Eminem");
        //check
        assertNotNull(authorFind);
        assertEquals(author1.getName(), authorFind.getName());
        verify(authorDao, atLeastOnce()).getByName(anyString());
        verifyNoMoreInteractions(authorDao);
    }
}