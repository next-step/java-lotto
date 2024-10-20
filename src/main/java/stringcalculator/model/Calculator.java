package stringcalculator.model;

import java.util.Collections;
import java.util.List;

import static stringcalculator.util.Parser.operands;
import static stringcalculator.util.Parser.operators;

public class Calculator {
    public static final int FIRST_INDEX = 0;
    public static final int GET_OPERAND_OFFSET = 1;
    private final List<Operand> operands;
    private final List<Operator> operators;

    public Calculator(final List<Operand> operands, final List<Operator> operators) {
        this.operands = Collections.unmodifiableList(operands);
        this.operators = Collections.unmodifiableList(operators);
    }

    public static Calculator of(final Input input) {
        List<String> strings = input.value();
        return new Calculator(operands(strings), operators(strings));
    }

    public Result calculate() {
        Operand calculatedOperand = this.operands.get(FIRST_INDEX);
        for (int index = 0; index < operators.size(); index++) {
            Operand operand = operands.get(index + GET_OPERAND_OFFSET);
            calculatedOperand = operators.get(index).calculate(calculatedOperand, operand);
        }
        return new Result(calculatedOperand.value());
    }
}
