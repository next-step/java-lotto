package step1.controller;


import step1.domain.Calcurator;
import step1.domain.Texts;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        return Calcurator.getSum(new Texts(text));
    }
}
