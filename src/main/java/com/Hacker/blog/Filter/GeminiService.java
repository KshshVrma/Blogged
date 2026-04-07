package com.Hacker.blog.Filter;

import com.Hacker.blog.Scraper.Scrape;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

public class GeminiService {
    private final WebClient webClient;

    public GeminiService() {
        this.webClient = WebClient.create("https://api.gemini.com");
    }

    public List<Scrape> rankAndFilterPosts(List<Scrape> posts) {
        // Example API call (adjust based on Gemini API documentation)
        return posts.stream()
                .map(post -> {
                    String reasoning = webClient.post()
                            .uri("/rank")
                            .bodyValue(post)
                            .retrieve()
                            .bodyToMono(String.class)
                            .block();
                    post.setContent(reasoning); // Add reasoning to content
                    return post;
                })
                .collect(Collectors.toList());
    }
}