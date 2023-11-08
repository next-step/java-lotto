package calculator.controller;

import calculator.domain.Operation;
import calculator.domain.OperationValidator;
import calculator.domain.StringSplitter;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.util.List;
import java.util.Scanner;

public class CalculatorController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = InputView.input(scanner);

        OperationValidator.valid(input);
        List<String> operations = StringSplitter.splitOperation(input);
        List<Integer> numbers = StringSplitter.splitNumbers(input);

        int basicNumber = numbers.get(0);
        for(int i = 0; i < operations.size(); i++) {
            Operation operation = Operation.searchBy(operations.get(i));
            basicNumber = operation.calculate(basicNumber, numbers.get(i + 1));
        }

        ResultView.report(basicNumber);
    }

}
