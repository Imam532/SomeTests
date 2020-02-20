package javamentor.app.dao.impl;

import javamentor.app.dao.abstraction.AuthorDao;
import javamentor.app.model.Author;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
@Transactional//(readOnly = true)
public class AuthorDaoImpl extends AbstractDao<Long, Author> implements AuthorDao {

    public AuthorDaoImpl() {
        super(Author.class);
    }

    @Override
    public Author getByName(String name) {
        TypedQuery<Author> query = entityManager.createQuery("FROM Author WHERE name = :name", Author.class);
        query.setParameter("name", name);
        Author author;
        try {
            author = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return author;
    }
}