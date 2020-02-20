package javamentor.app.controller.restcontroller;


import groovy.transform.WithWriteLock;
import javamentor.app.model.Author;
import javamentor.app.model.Song;
import javamentor.app.service.abstraction.AuthorService;
import javamentor.app.service.abstraction.SongService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

import static javamentor.app.util.CrudInterceptor.reset;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminAuthorRestControllerIntegrationTest {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private SongService songService;

    private Author author;
    private Song song;

    @Before
    public void setUp() {

    }

    @Test
    @Transactional
    public void getByIAuthor() {
        reset();
        author = authorService.getById(1L);
        System.out.println(author.toString());

    }

    @Test
    @Transactional
    public void getAllAuthor() {
        reset();
        List<Author> authors = authorService.getAllAuthor();
        for (Author author : authors) {
            System.out.println(author.toString());
        }
    }

    @Test
    @Transactional
    public void getSongById() {
        reset();
        song = songService.getById(1L);


    }

    @Test
    @Transactional
    public void getAllSong() {
        reset();

        List<Song> songs = songService.getAllSong();

        for (Song song : songs) {
            System.out.println("\n Песня: " + song.getName()
                    + "\n исполняет: " + song.getAuthor().getName()
                    + "\n в жанре: " + song.getGenre().getName());
        }

    }
}
