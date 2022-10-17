package calculator.input;

import calculator.operator.OperatorType;

import java.util.List;
import java.util.stream.Collectors;

import static calculator.input.InputIntegers.NUMBER_REGEX;

public class InputOperators {

    private final List<OperatorType> operators;

    public InputOperators(List<OperatorType> operatorInputs) {
        this.operators = operatorInputs;
    }

    public static InputOperators from(InputStrings inputStrings) {
        List<OperatorType> result = inputStrings.getStream()
                .filter(str -> !str.matches(NUMBER_REGEX))
                .map(OperatorType::from)
                .collect(Collectors.toList());
        return new InputOperators(result);
    }

    public List<OperatorType> getOperators() {
        return this.operators;
    }
}
