package stringcalculator.model;

import java.util.*;

public class Calculator {
    public static final int FIRST_INDEX = 0;
    public static final int OPERATOR_LOOP_START_INDEX = 1;
    public static final int OPERAND_LOOP_START_INDEX = 0;
    public static final int LOOP_INCREASE = 2;
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

    private static List<Operator> operators(List<String> strings) {
        List<Operator> operators = new ArrayList<>();
        for (int index = OPERATOR_LOOP_START_INDEX;
             index < strings.size();
             index = index + LOOP_INCREASE) {
            operators.add(Operator.convertToOperator(strings.get(index)));
        }
        return operators;
    }

    private static List<Operand> operands(List<String> strings) {
        List<Operand> operands = new ArrayList<>();
        for (int index = OPERAND_LOOP_START_INDEX;
             index < strings.size();
             index = index + LOOP_INCREASE) {
            operands.add(new Operand(strings.get(index)));
        }
        return operands;
    }

    public Result calculate() {
        Operand calculatedOperand = this.operands.get(FIRST_INDEX);
        for (int index = 0; index < operators.size(); index++) {
            Operand operand = operands.get(index + 1);
            calculatedOperand = operators.get(index).calculate(calculatedOperand, operand);
        }
        return new Result(calculatedOperand.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(operands, that.operands) && Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators);
    }
}
