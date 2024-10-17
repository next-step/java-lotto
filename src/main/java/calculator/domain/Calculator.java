package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calculator {
    private final Operands operands;
    private final Operators operators;

    private Calculator(Operands operands, Operators operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public static Calculator create(String input) {
        if (Objects.isNull(input) || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자일수 없습니다.");
        }
        return create(input.split(" "));
    }

    private static Calculator create(String[] operatorsOperands) {
        return new Calculator(extractOperands(operatorsOperands), extractOperators(operatorsOperands));
    }

    private static Operators extractOperators(String[] operatorsOperands) {
        List<OperatorType> operators = new ArrayList<>();

        for (int position = 1; position < operatorsOperands.length; position+=2) {
            operators.add(OperatorType.from(operatorsOperands[position]));
        }
        return new Operators(operators);
    }

    private static Operands extractOperands(String[] operatorsOperands) {
        List<OperandNumber> operands = new ArrayList<>();

        for (int position = 0; position < operatorsOperands.length; position+=2) {
            operands.add(OperandNumber.create(operatorsOperands[position]));
        }
        return new Operands(operands);
    }

    public OperandNumber calculate() {
        int position = 0;
        OperandNumber result = operands.valueAt(position);

        while (position < this.operateCount()) {
            result = operators.execute(position, result, operands.valueAt(position + 1));
            position++;
        }
        return result;
    }

    private int operateCount() {
        return operators.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return operands.equals(that.operands) && operators.equals(that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands, operators);
    }
}
