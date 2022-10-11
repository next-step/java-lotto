package main.string_calculator.model;

import main.string_calculator.util.NumberUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static main.string_calculator.util.NumberUtil.*;

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

    public Integer multiply(Integer firstNumber, Integer secondNumber) {
        return firstNumber * secondNumber;
    }

    public Integer divide(Integer firstNumber, Integer secondNumber) {
        return isEssence(firstNumber, secondNumber);
    }
}
