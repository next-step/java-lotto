package kr.insup.calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int calculate(String input) {
        String delimiter = InputParser.getDelimiter(input);
        String onlyNumbers = InputParser.getOnlyNumbers(input);
        System.out.println("delimiter = " + delimiter);
        System.out.println("onlyNumbers = " + onlyNumbers);
        String[] numbers = onlyNumbers.split(delimiter);

        return calculateNumbers(numbers);
    }

    private int calculateNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += InputParser.stringToIntConverter(number);
        }
        return sum;
    }
}
