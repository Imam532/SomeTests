package javamentor.app.dao.abstraction;


import javamentor.app.model.Song;

public interface SongDao extends GenericDao<Long, Song> {

    Song getByName(String name);
}

