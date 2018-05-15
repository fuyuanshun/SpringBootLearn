package com.fys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class JDBCController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("testJdbcTemplate")
    public String testJdbcTemplate() {
        jdbcTemplate.update("insert into book values(3, \"fys's book\", 'xyj', 'xyj', 2, 2)");
        return "ok!";
    }

    @RequestMapping("/testTemplate")
    public String testTemplate() {
        String ret = "";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select name from book");
        for (Map map: maps) {
            Set keys = map.keySet();
            Iterator it = keys.iterator();
            while (it.hasNext()) {
                ret += map.get(it.next())+" ";
            }
        }
        return ret;
    }
}
