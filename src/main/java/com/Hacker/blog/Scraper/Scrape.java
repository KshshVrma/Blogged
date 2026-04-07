package com.Hacker.blog.Scraper;
import com.Hacker.blog.Scraper.Scrapes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Scrape {
    public List<Scrapes> Scrape() throws IOException {
        List<Scrapes> posts = new ArrayList<>();
        Document doc = Jsoup.connect("https://news.ycombinator.com/").get();
        Elements titles = doc.select(".titleline > a");

        for (Element title : titles) {
            String postTitle = title.text();
            String postUrl = title.attr("href");
            posts.add(new Scrapes(postTitle, postUrl));
        }
        return posts;
    }
}