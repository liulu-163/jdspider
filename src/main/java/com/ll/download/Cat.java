package com.ll.download;

import static com.ll.download.Getcontent.doGet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author liulu
 * @create 2019-12-19 16:36
 */
public class Cat {

    public String getCat(String url) {
        String text = doGet(url);
        Document doc = Jsoup.parse(text);
        Elements elements = doc.select("body");
        String venderid = elements.select("div[data-vid]").attr("data-vid");
        String classvalue = elements.get(0).attr("class");
        String[] str = classvalue.replace(" ", "").split("cat-1-|cat-2-|cat-3-|cat-4");
        String cat = "&area=1_72_2799_0&venderId=" + venderid + "&cat=" + str[1] + "," + str[2] + "," + str[3];
        return cat;

    }
}
