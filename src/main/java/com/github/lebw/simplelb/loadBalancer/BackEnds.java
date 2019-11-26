package com.github.lebw.simplelb.loadBalancer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BackEnds {
    private int current;

    private ArrayList<BackEnd> backEnds = new ArrayList<>();
    // Here to autowire in constructor
    public BackEnds(String[] urlArray) {
        current = 0;
        int len = urlArray.length;
        for (String s : urlArray) {
            BackEnd end = new BackEnd(s);
            backEnds.add(end);
        }
    }

    public BackEnd getNextBackEnd() {
        BackEnd nextBackEnd = backEnds.get(current);
        current = (current + 1) % backEnds.size();
        return nextBackEnd;
    }
}

class BackEnd {
    private String url;
    private boolean isAlive;
    BackEnd(String url) {
        this.url = url;
        this.isAlive = true;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}



