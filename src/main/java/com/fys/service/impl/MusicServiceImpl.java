package com.fys.service.impl;

import com.fys.mapper.MusicMapper;
import com.fys.model.Music;
import com.fys.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper mapper;

    @Override
    public int add(Music music) {
        return mapper.add(music);
    }

    @Override
    public int update(Music music) {
        return mapper.update(music);
    }

    @Override
    public int deleteById(Integer id) {
        return mapper.deleteById(id);
    }

    @Override
    public List<Music> selectAllMusic() {
        return mapper.selectAllMusic();
    }

    @Override
    public Music selectMusicById(Integer id) {
        return mapper.selectMusicById(id);
    }

    @Override
    public int selectMusicCount() {
        return mapper.selectMusicCount();
    }

    @Override
    public List<Music> selectMusicByLimit(Integer currentPage, Integer pageSize) {
        return mapper.selectMusicByLimit((currentPage-1)*10, pageSize);
    }
}
