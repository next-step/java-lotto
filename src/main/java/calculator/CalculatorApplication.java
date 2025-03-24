package calculator;

import calculator.domain.OperationUnit;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();

    public static void main(String[] args) {
        String[] elements = INPUT_VIEW.getInput().split(" ");

        OperationUnit operationUnit = new OperationUnit();
        for (String element : elements) {
            operationUnit.add(element);

            if (operationUnit.isCalculable()) {
                operationUnit.calculate();
            }
        }

        OUTPUT_VIEW.printOutput(operationUnit.getResult());
    }

}
