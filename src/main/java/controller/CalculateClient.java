package controller;


import domain.CalculateHandler;

public class CalculateClient {

    public static int process(String input) {
        if (isNullOrEmpty(input)) throw new IllegalArgumentException();
        String[] splitInput = input.split(" ");
        CalculateHandler calculate = new CalculateHandler();
        for (String split : splitInput) {
            calculate.handle(split);
        }
        calculate.validateIfOperationPlacedInLast();
        return calculate.getResult();
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || "".equals(input);
    }
}
