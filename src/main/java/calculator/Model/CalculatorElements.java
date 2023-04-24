package calculator.Model;

import calculator.Enums.Operator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorElements {
    private final List<Number> numbers;
    private final List<Operator> operators;

    public CalculatorElements(List<Number> inputNumbers, List<Operator> inputOperators) {
        numbers = new ArrayList<>(inputNumbers);
        operators = new ArrayList<>(inputOperators);
    }

    public List<Number> numbers() {
        return numbers;
    }

    public List<Operator> operators() {
        return operators;
    }
}
