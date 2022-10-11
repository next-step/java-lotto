package main.string_calculator.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public List<String> makeInputList(String input) {
        return Arrays.stream(input.split(" "))
                .collect(Collectors.toList());
    }

    public Integer add(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    public Integer sub(Integer firstNumber, Integer secondNumber) {
        return firstNumber - secondNumber;
    }
}
