package controller;

import domain.Calculator;
import view.Result;

import java.util.List;
import java.util.Scanner;

public class CalculatorController {

    private final static Result result = new Result();
    private final static Calculator calculator = new Calculator();

    private static final String DIVISION_WORD= " ";

    public void run() {
        process(split(result.input()));
    }

    private List<String> split(String input) {
        return List.of(input.split(DIVISION_WORD));
    }

    private void process(List<String> list) {
        int value = Integer.parseInt(list.get(0));
        calculator.basic(value);
        for (int i = 1; i < list.size(); i = i + 2) {
            String symbol = list.get(i);
            int num = numCheck(list.get(i + 1));
            calculator.operation(num, symbol);
        }
        result.print(calculator.getNowValue());
    }

    private int numCheck(String num) {
        try {
            return Integer.parseInt(num);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }
}
