package stringcalculator.util;

import stringcalculator.model.Operand;
import stringcalculator.model.Operator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static final int OPERAND_LOOP_START_INDEX = 0;
    public static final int OPERATOR_LOOP_START_INDEX = 1;
    public static final int LOOP_INCREASE = 2;
    public static List<Operand> operands(List<String> strings) {
        List<Operand> operands = new ArrayList<>();
        for (int index = OPERAND_LOOP_START_INDEX;
             index < strings.size();
             index = index + LOOP_INCREASE) {
            String operand = strings.get(index);
            operands.add(Operand.of(operand));
        }
        return operands;
    }

    public static List<Operator> operators(List<String> strings) {
        List<Operator> operators = new ArrayList<>();
        for (int index = OPERATOR_LOOP_START_INDEX;
             index < strings.size();
             index = index + LOOP_INCREASE) {
            String operator = strings.get(index);
            operators.add(Operator.convertToOperator(operator));
        }
        return operators;
    }
}
