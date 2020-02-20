package javamentor.app.dao.abstraction;


import javamentor.app.model.Author;

public interface AuthorDao extends GenericDao<Long, Author> {
    Author getByName(String name);


}
