package javamentor.app.dao.abstraction;


import javamentor.app.model.Genre;

public interface GenreDao extends GenericDao<Long, Genre> {
    Genre getByName(String name);

}

