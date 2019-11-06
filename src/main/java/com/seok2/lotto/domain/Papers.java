package com.seok2.lotto.domain;

import java.util.LinkedList;
import java.util.Queue;

public class Papers {

    private final static Papers EMPTY = new Papers(new LinkedList<>());

    private final Queue<Paper> papers;

    private Papers(Queue<Paper> papers) {
        this.papers = papers;
    }

    public static Papers empty() {
        return EMPTY;
    }

    public static Papers of(Queue<Paper> papers) {
        return new Papers(papers);
    }

    protected int size() {
        return papers.size();
    }

    protected String next() {
        return papers.poll().toString();
    }

    protected boolean isNotEmpty() {
        return !papers.isEmpty();
    }

}
