package com.citemachine.controller;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/spider")
public class SpiderController {

    @RequestMapping("/query")
    @ResponseBody
    public JSONObject getNextLevel(@RequestParam("url")String url) throws IOException {
        JSONObject json=new JSONObject();
        json.put("url",url);
        Document doc   = Jsoup.connect(url).get();
        Elements eles =doc.select("head > title");
        String title=eles.first().text();
        System.out.println(title);
        json.put("title",title);
        return json;
    }


}
