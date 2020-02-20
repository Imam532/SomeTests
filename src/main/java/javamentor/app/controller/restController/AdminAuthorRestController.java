package javamentor.app.controller.restController;

import javamentor.app.model.Author;
import javamentor.app.model.Genre;
import javamentor.app.model.Song;
import javamentor.app.service.abstraction.AuthorService;
import javamentor.app.service.abstraction.GenreService;
import javamentor.app.service.abstraction.SongService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/admin/author/")
public class AdminAuthorRestController {

    private final AuthorService authorService;
    private final GenreService genreService;
    private final SongService songService;

    public AdminAuthorRestController(AuthorService authorService, GenreService genreService, SongService songService) {
        this.authorService = authorService;
        this.genreService = genreService;
        this.songService = songService;
    }

    @GetMapping(value = "/all_authors")
    public List<Author> getAllAuthor(){
        List<Author> list = authorService.getAllAuthor();
        return list;
    }

    @GetMapping(value = "/author={id}")
    public Author getByIdAuthor(@PathVariable(value = "id") Long authorId){
        return authorService.getById(authorId);
    }


    @PostMapping(value = "/add_author")
    public void addAuthor(@RequestBody Author newAuthor) {
        String name = newAuthor.getName();
        if (authorService.getByName(name) == null) {
            Author author = new Author();
            author.setName(name);
            author.setGenres(newAuthor.getGenres());
            authorService.addAuthor(author);
        }
    }


    @DeleteMapping(value = "/delete_author")
    public void deleteAuthor(@RequestBody Long id){
        authorService.deleteAuthorById(id);
    }

    @GetMapping(value = "/all_genre")
    @ResponseBody
    public List<Genre> getAllGenre() {
        List<Genre> list = genreService.getAllGenre();
        return list;
    }

    @GetMapping("/all_songs")
    public List<Song> getAllSong() {
        return songService.getAllSong();
    }

    @GetMapping("/song={id}")
    public Song getSongById(@PathVariable(value = "id") Long id) {
        return songService.getById(id);
    }


}
