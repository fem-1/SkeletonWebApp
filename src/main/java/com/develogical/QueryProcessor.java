package com.develogical;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
        }else if (query.toLowerCase().contains("plus")){
            return String.valueOf(add(parseAdd(query)));
        } else if (query.toLowerCase().contains("multiplied")){
            return String.valueOf(multiply(parseAdd(query)));
        }else if(query.toLowerCase().contains("largest")){
            return String.valueOf(returnLargest(parseLargest(query)));
        }
//        else if(query.toLowerCase().contains("cube")){
//            return String.valueOf(returnLargest());
//        }
        return "";

    }

    public String[] parseMultiply(String query){
        String result = query.replaceAll("\\?", "");

        String[] splitStr = result.split("\\s+");
        return splitStr;
    }

    public int multiply(String[] query){
        int firstNum =Integer.parseInt(query[2]);
        int secondNum =Integer.parseInt(query[5]);
        return firstNum*secondNum;
    }

    public String[] parseLargest(String query){

        String result = query.replaceAll("\\?", "");
        result = result.replaceAll(",", "");
        String[] splitStr = result.split("\\s+");

        return splitStr;
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

    public Integer returnLargest(String[] splitQuery){
        int[] intArray = {Integer.parseInt(splitQuery[8]), Integer.parseInt(splitQuery[9]), Integer.parseInt(splitQuery[10])};
        int max = Arrays.stream(intArray).max().getAsInt();
        return max;
    }

    public ArrayList<Integer> getNumbersFromString(String query){
        String result = query.replaceAll("\\?", "");
        result = query.replaceAll(",", "");
        String[] tidied = result.split("\\s+");

        ArrayList<Integer> numbers = new ArrayList<>();
        for (String number : tidied){
            System.out.println(number);
            if (isNumeric(number)){
                numbers.add(Integer.parseInt(number));
            }

        }
        System.out.println(numbers);

        return numbers;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}


