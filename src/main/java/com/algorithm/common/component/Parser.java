package com.algorithm.common.component;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class Parser {
    public Document readDocument(String url) throws Exception {
        return Jsoup.connect(url).get();
    }
    public abstract void parse(String problemNumber) throws Exception;
}
