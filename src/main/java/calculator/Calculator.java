package calculator;

import calculator.input.InputIntegers;
import calculator.input.InputOperators;
import calculator.input.InputStrings;
import calculator.operator.OperatorFactory;
import calculator.operator.OperatorType;

public class Calculator {

    public int execute(String input) {
        InputStrings inputStrings = InputStrings.from(input);
        InputIntegers inputIntegers = InputIntegers.from(inputStrings);
        InputOperators inputOperators = InputOperators.from(inputStrings);
        return calculate(inputIntegers, inputOperators);
    }

    private Integer calculate(InputIntegers inputIntegers, InputOperators inputOperators) {
        OperatorFactory operatorFactory = new OperatorFactory();
        for (OperatorType type : inputOperators.getOperators()) {
            inputIntegers.executeOperator(operatorFactory.getOperator(type));
        }
        return inputIntegers.getResult();
    }

}
