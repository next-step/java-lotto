package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static final InputView INPUT_VIEW = new InputView();

    public static void main(String[] args) {
        String[] elements = INPUT_VIEW.getInput().split(" ");

        OperationUnit operationUnit = new OperationUnit();
        for (String element : elements) {
            operationUnit.add(element);

            if (operationUnit.isCalculable()) {
                int result = Calculator.calculateOperationUnit(operationUnit);
                operationUnit.passPreviousResult(result);
            }
        }

        System.out.println(operationUnit.getResult());
    }

}
