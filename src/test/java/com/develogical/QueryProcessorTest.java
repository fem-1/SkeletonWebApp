package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsAboutChatGPT() throws Exception {
        assertThat(queryProcessor.process("ChatGPT"), containsString("chat"));
    }

    @Test
    public void whatIsYourName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("Femi"));
    }

//    @Test
//    public void whichNumberIsLarges() throws Exception {
//        assertThat(queryProcessor.process("Which of the following numbers is the largest: 34, 20, 27?"), containsString("34"));
//    }
@Test
    public void addTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("What is 72 plus 54?"), containsString("126"));
    }
    @Test
    public void addTwoNumbersTenAndFive() throws Exception {
        assertThat(queryProcessor.process("What is 10 plus 5?"), containsString("15"));
    }
    @Test
    public void multiplyTwoNumbers() throws Exception {
        assertThat(queryProcessor.process("What is 12 multiplied by 33?"), containsString("396"));


    }


    @Test
    public void LargestNumber() throws Exception{
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 59, 88, 65?"), containsString("88"));
    }
    @Test
    public void squareAndCube() throws Exception{
        assertThat(queryProcessor.process("Which of the following numbers is both a square and a cube: 816, 64, 729, 740, 3136, 4170, 3564?"), containsString("64,729"));
    }

    @Test
    public void isCube(){
        assertThat(queryProcessor.isCube(729), is(false));
    }
    @Test
    public void isNotCube(){
        assertThat(queryProcessor.isCube(28), is(false));
    }
    @Test
    public void isSquare(){
        assertThat(queryProcessor.isSquare(729), is(true));
    }
    @Test
    public void isNotSquare(){
        assertThat(queryProcessor.isSquare(10), is(false));
    }
}
