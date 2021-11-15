package step1.view;

import step1.domain.Calculator;

import java.util.List;

public class Output {

    public static void output(List<Integer> input) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.Add(input).getNum());
    }
}
