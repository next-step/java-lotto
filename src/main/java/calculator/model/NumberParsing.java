package calculator.model;


import calculator.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class NumberParsing {

    public static List<Number> addNumber(String[] input) {
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < input.length; i += 2) {
            numbers.add(new Number(input[i]));
        }

        return numbers;
    }

}
