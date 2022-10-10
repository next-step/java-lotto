package service;

import java.util.List;

import domain.Operand;
import enums.Operator;

public class Calculator {

    private int result = 0;

    public int calculateInputValue(InputValueParser inputValueParser) {

        List<Operator> operators = inputValueParser.parsingOperators();
        List<Operand> operands = inputValueParser.parsingOperands();

        for (int i = 0; i < operators.size(); i++) {

            Operand operand = operators.get(i)
                .operate(operands.get(i).getOperand(), operands.get(i + 1).getOperand());
            result += operand.getOperand();
        }
        return result;
    }
}
