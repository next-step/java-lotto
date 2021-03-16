package step1.controller;


import step1.domain.Calcurator;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        Calcurator calcurator = new Calcurator(text);
        calcurator.sum();

        return calcurator.getSum();
    }
}
