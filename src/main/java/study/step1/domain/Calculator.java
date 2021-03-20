package study.step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final List<PositiveNumber> positiveNumberList;
    private int sum = 0;

    public Calculator(String input) {
        String[] splitStringNumbers = splitInput(input);
        positiveNumberList = stringToPositveNumbers(splitStringNumbers);
    }

    private List<PositiveNumber> stringToPositveNumbers(String[] stringNumbers) {
        List<PositiveNumber> numbers = new ArrayList<>();
        for(String number : stringNumbers) {
            numbers.add(new PositiveNumber(number));
        }
        return numbers;
    }

    private String[] splitInput(String input) {
        String separator = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            separator = m.group(1);
            return m.group(2).split(separator);
        }
        return input.split(separator);
    }

    public int sum() {
        return positiveNumberList.stream().mapToInt(PositiveNumber::getNumber).sum();
    }

}
