package com.fys.service;


import com.fys.model.Music;

import java.util.List;

public interface MusicService {
    int add(Music music);

    int update(Music music);

    int deleteById(Integer id);

    List<Music> selectAllMusic();

    Music selectMusicById(Integer id);

    int selectMusicCount();

    List<Music> selectMusicByLimit(Integer currentPage, Integer PageSize);
}
