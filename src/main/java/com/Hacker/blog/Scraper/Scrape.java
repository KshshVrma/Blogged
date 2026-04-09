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
    public static class Post {
        private String title;
        private String url;

        public Post(String title, String url) {
            this.title = title;
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public String getUrl() {
            return url;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", URL: " + url;
        }
    }
    public List<Post> scrapeHackerNews() throws IOException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect("https://news.ycombinator.com/").get();
        Elements titles = doc.select(".titleline > a");

        for (Element title : titles) {
            String postTitle = title.text();
            String postUrl = title.attr("href");
            posts.add(new Post(postTitle, postUrl));
        }
        return posts;
    }

//    public static void main(String[] args) {
//        Scrape scraper = new Scrape();
//        try {
//            List<Post> posts = scraper.scrapeHackerNews();
//            posts.forEach(System.out::println);
//        } catch (IOException e) {
//            System.err.println("Error scraping Hacker News: " + e.getMessage());
//        }
//    }

}