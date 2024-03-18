package controller;


import domain.Calculate;

public class CalculateClient {

    public static int process(String input) {
        if(isNullOrEmpty(input)) throw new IllegalArgumentException();
        String[] splitInput = input.split(" ");
        Calculate calculate = new Calculate();
        for(String split : splitInput){
            calculate.process(split);
        }
        return calculate.getResult();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || "".equals(input);
    }
}
