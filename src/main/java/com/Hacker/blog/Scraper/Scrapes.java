package com.Hacker.blog.Scraper;

public class Scrapes {
    String postTitle;
    String postUrl;
    public Scrapes(String postTitle, String postUrl) {
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }
}
