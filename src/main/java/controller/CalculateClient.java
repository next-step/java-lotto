package controller;


import domain.CalculateHandler;
import domain.Separation;
import domain.SeparationDto;

public class CalculateClient {

    public static int process(String input) {
        if (isNullOrEmpty(input)) throw new IllegalArgumentException();
        String[] splitInput = input.split(" ");
        SeparationDto dto = new Separation().separate(splitInput);
        return new CalculateHandler().handle(dto);
    }

    private static boolean isNullOrEmpty(String input) {
        return input == null || "".equals(input);
    }
}
