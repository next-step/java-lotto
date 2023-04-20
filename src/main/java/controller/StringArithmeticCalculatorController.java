package controller;

import domain.Operator;
import view.InputView;

import java.util.List;

public class StringArithmeticCalculatorController {
    public static void main(String[] args) {
        String inputExpression = InputView.inputExpression();
        List<Integer> numbers = InputView.extractNumbers(inputExpression);
        List<String> operators = InputView.extractOperators(inputExpression);

        int sum = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            sum = Operator.calculator(operators.get(i), sum, numbers.get(i + 1));
        }

        System.out.println(sum);
    }
}
