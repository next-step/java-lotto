package calculator.domain;

import calculator.operatorenum.*;

import java.util.Deque;
import java.util.List;

public class Calculator {

    private String text;

    private final Deque<Integer> inputNumbers;
    private final Deque<String> inputOperators;

    public Calculator(String text) {
        Parser.emptyValidate(text);

        List<String> splitText = Parser.split(text);

        this.inputNumbers = Parser.numberParsing(splitText);
        this.inputOperators = Parser.operatorParsing(splitText);

    }
    public int calculate() {
        int totalOperatorsSize = inputOperators.size();
        for (int i = 0; i < totalOperatorsSize; i++) {
            String operator = inputOperators.pollFirst();
            Integer firstNumber = inputNumbers.pollFirst();
            Integer secondNumber = inputNumbers.pollFirst();

            inputNumbers.addFirst(OperatorEnum.calculate(operator, firstNumber, secondNumber));

        }
        return inputNumbers.pop();
    }
}
