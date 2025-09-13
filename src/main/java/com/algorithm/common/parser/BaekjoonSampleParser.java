package com.algorithm.common.parser;

import com.algorithm.common.component.Parser;
import com.algorithm.common.component.PropertiesReader;
import com.algorithm.common.component.ResourceHandler;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BaekjoonSampleParser extends Parser {

    private final String BAEKJOON_URL;

    public BaekjoonSampleParser() {
        this.BAEKJOON_URL = PropertiesReader.get("url.baekjoon");
    }

    @Override
    public void parse(String problemNumber) throws Exception {
        /** 경로 생성 **/
        ResourceHandler.createDirectory(problemNumber);

        /** 데이터 조회 **/
        String targetProblemUrl = String.join("/", BAEKJOON_URL, "problem", problemNumber);
        Document dom = super.readDocument(targetProblemUrl);
        Elements sampleDataElements = dom.getElementsByClass("sampledata");

        int fileIndex = 0;

        for(int i = 0; i < sampleDataElements.size(); i++) {
            Element element = sampleDataElements.get(i);
            String dataName = null;
            String content  = null;
            switch(i % 2) {
                case 0 -> { // input
                    content = element.html().replaceAll("\r", "");
                    dataName = String.join("-", "INPUT", problemNumber, String.valueOf(fileIndex)) + ".txt";
                }
                case 1 -> { // output
                    content = element.html().replaceAll("\r", "");
                    dataName = String.join("-", "OUTPUT", problemNumber, String.valueOf(fileIndex)) + ".txt";
                    fileIndex++;
                }
            }

            if(dataName == null) continue;



            /** 데이터 입력 **/
            ResourceHandler.createFile(problemNumber, dataName);
            ResourceHandler.writeToFile(problemNumber, dataName, content);


        }



        System.out.println("Sample Data for Problem " + problemNumber);

    }


}
