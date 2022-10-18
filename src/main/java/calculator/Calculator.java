package calculator;

import calculator.input.InputIntegers;
import calculator.input.InputOperators;
import calculator.input.InputStrings;
import calculator.operator.OperatorType;

public class Calculator {

    public int execute(String input) {
        InputStrings inputStrings = InputStrings.from(input);
        InputIntegers inputIntegers = InputIntegers.from(inputStrings);
        InputOperators inputOperators = InputOperators.from(inputStrings);
        return calculate(inputIntegers, inputOperators);
    }

    private Integer calculate(InputIntegers inputIntegers, InputOperators inputOperators) {
        for (OperatorType type : inputOperators.getOperators()) {
            inputIntegers.executeOperator(type.getOperator());
        }
        return inputIntegers.getResult();
    }

}
