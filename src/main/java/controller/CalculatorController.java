package controller;

import domain.Calculator;
import view.Result;

import java.util.List;
import java.util.Scanner;

public class CalculatorController {

    private final static Result result = new Result();
    private final static Calculator calculator = new Calculator();

    private static final String DIVISION_WORD= " ";

    public void input() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("잘못된 입력값 입니다");
        process(split(input));
    }

    private List<String> split(String input) {
        return List.of(input.split(DIVISION_WORD));
    }

    private void process(List<String> list) {
        int value = Integer.parseInt(list.get(0));
        calculator.basic(value);
        for (int i = 1; i < list.size(); i = i + 2) {
            String symbol = list.get(i);
            int num = Integer.parseInt(list.get(i + 1));
            calculator.operation(num, symbol);
        }
        result.print(calculator.getNowValue());
    }
}
