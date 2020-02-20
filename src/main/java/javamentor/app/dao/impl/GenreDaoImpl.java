package javamentor.app.dao.impl;

import javamentor.app.dao.abstraction.GenreDao;
import javamentor.app.model.Author;
import javamentor.app.model.Genre;
import javamentor.app.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
@Transactional//(readOnly = true)
public class GenreDaoImpl extends AbstractDao<Long, Genre> implements GenreDao {
    GenreDaoImpl() {
        super(Genre.class);
    }

    @Override
    public Genre getByName(String name) {
        TypedQuery<Genre> query = entityManager.createQuery("SELECT u FROM Genre u WHERE u.name = :name", Genre.class);
        query.setParameter("name", name);
        Genre genre;
        try {
            genre = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return genre;
    }

    @Override
    public void deleteById(Long id) {

        TypedQuery<Author> queryAuthor = (TypedQuery<Author>) entityManager.createNativeQuery("DELETE FROM author_on_genre WHERE genre_id = :id");
        queryAuthor.setParameter("id", id);
        queryAuthor.executeUpdate();

        TypedQuery<Song> querySong = (TypedQuery<Song>) entityManager.createQuery("UPDATE Song SET genre_id = null WHERE genre_id = :id");
        querySong.setParameter("id", id);
        querySong.executeUpdate();

        super.deleteById(id);
    }
}