package com.ll.parsejson;

import static com.ll.download.Getcontent.doGet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.ll.domain.Page;
import com.ll.download.Cat;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author liulu
 * @create 2019-12-19 13:23
 */
public class Parse {
    public void parseJSON(Page page) {
        String pageurl = "https://item.jd.com/" + page.getSkuid() + ".html";
        String catid = new Cat().getCat(pageurl);
        String priceurl = "https://c0.3.cn/stock?skuId=" + page.getSkuid() + catid;
        String json = doGet(priceurl);
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject stockjson = jsonObject.getJSONObject("stock");
            JSONObject jdPrice = stockjson.getJSONObject("jdPrice");
            page.setOriginPrice(jdPrice.getString("op"));
            page.setCurrePrice(jdPrice.getString("p"));
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("name", page.getName());
            jsonObject1.put("currentPrice", page.getCurrePrice());
            jsonObject1.put("originPrice", page.getOriginPrice());
            jsonObject1.put("crawlTime", page.getCrawltime());
            jsonObject1.put("skuid", page.getSkuid());
            jsonObject1.put("friCat", page.getFirCat());
            jsonObject1.put("secCat", page.getSecCat());
            jsonObject1.put("thrCat", page.getThrCat());
            jsonObject1.put("brand", page.getBrand());
            jsonObject1.put("type", page.getType());
            String goods = jsonObject1.toString();
            BufferedWriter out = new BufferedWriter(new FileWriter("E:\\output.txt", true));
            out.write(goods);
            out.newLine();
            out.close();

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

