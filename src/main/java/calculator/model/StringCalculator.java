package calculator.model;

import calculator.exception.ValidateInputException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calculator.util.NumberUtil.isNumber;

public class StringCalculator {

    public Integer calculate(String input) {
        List<String> inputList = makeInputList(input);

        Integer firstNumber = isNumber(inputList.get(0));

        for (int i = 1; i < inputList.size(); i += 2) {
            String operator = inputList.get(i);
            Integer secondNumber = isNumber(inputList.get(i + 1));
            firstNumber = Operator.calculate(operator, firstNumber, secondNumber);
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
            throw new ValidateInputException();
        }
        return input;
    }
}
