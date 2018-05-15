package com.fys.controller;

import com.fys.model.Music;
import com.fys.service.MusicService;
import com.fys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    /**
     * 查询所有的音乐， 展示在音乐列表
     * @return
     */
    @RequestMapping("/selectMusic")
    public ModelAndView selectMusic(HttpServletRequest req, HttpServletResponse resp) {
        Integer currentPage;
        String currentPageStr = req.getParameter("currentPage");
        if(null != currentPageStr && !currentPageStr.equals("")) {
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        if(currentPage == 0) {
            currentPage = 1;
        }

        ModelAndView modelAndView = new ModelAndView("/musicList");
        int count = musicService.selectMusicCount();
        /*List<Music> musicList = musicService.selectAllMusic();*/
        Page page = new Page();
        page.init(count);

        if(currentPage != null) {
            page.setCurrentPage(currentPage);
        }

        if(currentPage > page.getTotalPage()) {
            currentPage = page.getTotalPage();
        }

        List<Music> musicList = musicService.selectMusicByLimit(currentPage, page.getPageSize());
        modelAndView.addObject("musicList", musicList);
        modelAndView.addObject("totalPage", page.getTotalPage());
        modelAndView.addObject("currentPage", currentPage);
        return modelAndView;
    }


    /**
     * 添加一首音乐
     * @return
     */
    @RequestMapping("/addMusic")
    public String addMusic(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String link = req.getParameter("link");

        if(null != name && !name.equals("") && null !=link && !link.equals("")) {
            Music music = new Music(name, link);
            if(musicService.add(music) == 1) {
                return "redirect:/selectMusic?message=add success";
            } else {
                return "redirect:/selectMusic?message=add error";
            }
        } else {
            return "redirect:/selectMusic?message=add error";
        }
    }

    /**
     * 删除音乐
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping("/deleteMusic")
    public String deleteMusic(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        musicService.deleteById(id);
        return  "redirect:/selectMusic";
    }

    @RequestMapping("/updateMusic")
    public ModelAndView updateMusic(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Music music = musicService.selectMusicById(id);
        ModelAndView modelAndView = new ModelAndView("/update");

        modelAndView.addObject("music", music);
        return modelAndView;
    }

    @RequestMapping("/updateMusicDeal")
    public String updateMusicDeal(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String link = req.getParameter("link");

        Music music = new Music(name, link);
        music.setId(id);

        musicService.update(music);
        return "redirect:/selectMusic";
    }
}
