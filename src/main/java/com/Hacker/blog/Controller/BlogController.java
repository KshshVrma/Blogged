package com.Hacker.blog.Controller;

import com.Hacker.blog.Scraper.Scrape;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @GetMapping("/titles")
    String getBlogTitles() throws IOException {
        // Logic to scrape blog titles and return them as a list
        Scrape scrape = new Scrape();
        List<Scrape.Post> posts = scrape.scrapeHackerNews();
        posts.forEach(System.out::println);
        StringBuilder titles = new StringBuilder();
        posts.forEach(System.out::println);
        for(int i=0; i<posts.size(); i++){
            titles.append(i+1).append(". ").append(posts.get(i).getTitle()).append("\n")
                    .append(posts.get(i).getUrl()).append("\n");
        }
       return titles.toString();
    }
}
