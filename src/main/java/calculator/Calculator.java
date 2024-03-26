package calculator;

import inputview.InputView;

import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<List<String>> operandAndOperator = inputView.operandAndOperator();
        for (int i = 0 ; i < operandAndOperator.get(0).size(); i++) {
            System.out.println(operandAndOperator.get(0).get(i));
        }
        for (int i = 0 ; i < operandAndOperator.get(1).size(); i++) {
            System.out.println(operandAndOperator.get(1).get(i));
        }

    }
}
