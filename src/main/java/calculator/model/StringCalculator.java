package calculator.model;

import calculator.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.util.NumberUtil.validateNumber;
import static calculator.util.OperatorUtil.validateOperator;

public class StringCalculator {

    public Integer calculate(String input) {
        List<String> inputList = makeInputList(input);

        Integer firstNumber = validateNumber(inputList.get(0));

        for (int i = 1; i < inputList.size(); i += 2) {
            String operator = inputList.get(i);
            Integer secondNumber = validateNumber(inputList.get(i + 1));
            firstNumber = Operator.calculate(validateOperator(operator), firstNumber, secondNumber);
        }

        return firstNumber;
    }

    public List<String> makeInputList(String input) {
        String validateInput = validateInput(input);

        return Arrays.stream(validateInput.split(" "))
                .collect(Collectors.toList());
    }

    public String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new InvalidInputException();
        }
        return input;
    }
}
