package javamentor.app.configuration.initializer;

import javamentor.app.model.Author;

import javamentor.app.model.Genre;
import javamentor.app.model.Song;
import javamentor.app.service.abstraction.AuthorService;

import javamentor.app.service.abstraction.GenreService;
import javamentor.app.service.abstraction.SongService;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class TestDataInit {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;


    @Autowired
    private SongService songService;




    private void init() {

        Genre genre = new Genre("world");
        genreService.addGenre(genre);

        Genre genre1 = new Genre("hard rock");
        genreService.addGenre(genre1);

        Genre genre2 = new Genre("classic");
        genreService.addGenre(genre2);

        Genre genre3 = new Genre("folk");
        genreService.addGenre(genre3);

        Genre genre4 = new Genre("punk");
        genreService.addGenre(genre4);

        Author author = new Author();
        author.setName("Scooter");
        Set<Genre> genres = new HashSet<>();
        genres.add(genre);
        author.setGenres(genres);
        authorService.addAuthor(author);

        Author author2 = new Author();
        author2.setName("Gorillaz");
        Set<Genre> genres1 = new HashSet<>();
        genres1.add(genre1);
        author2.setGenres(genres1);
        authorService.addAuthor(author2);


        Song song = new Song("Attack on titan - Silence");
        song.setAuthor(author);
        song.setGenre(genre);
        songService.addSong(song);

        Song song1 = new Song("Naruto OST - Hero");
        song1.setAuthor(author);
        song1.setGenre(genre1);
        songService.addSong(song1);

        Song song2 = new Song("Hunter X Hunter - Jokers theme");
        song2.setAuthor(author);
        song2.setGenre(genre2);
        songService.addSong(song2);

        Song song3 = new Song("Death Note - Laits theme");
        song3.setAuthor(author);
        song3.setGenre(genre3);
        songService.addSong(song3);

        Song song4 = new Song("One punch man - Hero");
        song4.setAuthor(author);
        song4.setGenre(genre4);
        songService.addSong(song4);

    }
}
