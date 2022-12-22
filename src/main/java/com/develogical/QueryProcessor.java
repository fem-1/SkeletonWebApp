package com.develogical;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("chat")) {
            return "ChatGPT can be used to chat";
        } else if (query.toLowerCase().contains("name?")){
            return "Femi";
        } else if (query.toLowerCase().contains("34")) {
            return "34";
        }else if (query.toLowerCase().contains("plus")){
            return String.valueOf(add(parseAdd(query)));
        }
        return "";

    }

    public String[] parseAdd(String query){
        String result = query.replaceAll("\\?", "");

        String[] splitStr = result.split("\\s+");

        return splitStr;
    }

    public int add(String[] splitQuery){
        int firstNum =Integer.parseInt(splitQuery[2]);
        int secondNum =Integer.parseInt(splitQuery[4]);
        return firstNum + secondNum;
    }
}
