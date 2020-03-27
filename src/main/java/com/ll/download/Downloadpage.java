package com.ll.download;

import static com.ll.download.Getcontent.doGet;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ll.domain.Page;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author liulu
 * @create 2019-12-18 14:35
 */
public class Downloadpage {

    public Page getPage(String skuid) {
        Page page = new Page();
        try {
            String url = "https://item.jd.com/" + skuid + ".html";
            String goodspage = doGet(url);
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            page.setCrawltime(dateFormat.format(now));
            Document doc = Jsoup.parse(goodspage);
            Elements crumb = doc.select("div.crumb.fl.clearfix");
            String friCat = crumb.select("a[href]").get(0).text();
            String secCat = crumb.select("a[href]").get(1).text();
            String thrCat = crumb.select("a[href]").get(2).text();
            String brand = crumb.select("a[href]").get(3).text();
            String type = doc.select("div.item.ellipsis").text();
            String name = doc.select("div.sku-name").text();
            page.setBrand(brand);
            page.setName(name);
            page.setType(type);
            page.setFirCat(friCat);
            page.setSecCat(secCat);
            page.setThrCat(thrCat);
            page.setPageUrl(url);
            page.setSkuid(skuid);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

}
