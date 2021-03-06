package javamentor.app.service.abstraction;

import javamentor.app.model.Song;

import java.util.List;

public interface SongService {

    List<Song> getAllSong();

    Song getByName(String name);

    void addSong(Song song);

    void updateSong(Song song);

    void deleteSongById(Long id);


    Song getById(long songId);
}
