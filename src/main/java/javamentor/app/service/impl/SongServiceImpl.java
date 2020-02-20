package javamentor.app.service.impl;

import javamentor.app.dao.abstraction.SongDao;
import javamentor.app.model.Song;
import javamentor.app.service.abstraction.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
//@Transactional
public class SongServiceImpl implements SongService {

    private final SongDao songDao;

    @Autowired
    public SongServiceImpl(SongDao songDao) {
        this.songDao = songDao;
    }

    @Override
    public List<Song> getAllSong() {
        return songDao.getAll();
    }

//    @Override
//    @Fetch(FetchMode.JOIN) //подгружаем внутренние объекты
//    public List<Song> getAllSongNonLazy() {
//        return songDao.getAll();
//    }

    @Override
    public void deleteSongById(Long id) {
        songDao.deleteById(id);
    }

    @Override
    public void addSong(Song song) {
        songDao.save(song);
    }

    @Override
    public Song getByName(String name) {
        return songDao.getByName(name);
    }

//    @Override
//    public Song getSongById(long id) {
//        return songDao.getById(id);
//    }



    @Override
    public Song getById(long songId) {
        return songDao.getById(songId);
    }


    @Override
    public void updateSong(Song song) {
        songDao.update(song);
    }

//    @Override
//    @Fetch(FetchMode.JOIN) //подгружаем внутренние объекты
//    public void updateSongNonLazy(Song song) {
//        songDao.update(song);
//    }

}