package javamentor.app.service.abstraction;

import javamentor.app.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthor();

    Author getByName(String name);

    void addAuthor(Author author);

    /**
     * Возвращает автора по id
     * @return Author
     */
    Author getById(long authorsId);

    void updateAuthor(Author author);

    void deleteAuthorById(Long id);
}
