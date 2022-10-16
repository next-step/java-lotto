package StringCalculator.backend.controller;

import StringCalculator.backend.domain.NumberSentence;
import StringCalculator.backend.domain.Operand;
import StringCalculator.backend.domain.Operator;
import StringCalculator.backend.domain.OperatorFactory;

import java.util.List;

public class CalculatorController {

    public int run(String numberOfSentence) {
        NumberSentence numberSentence = new NumberSentence(numberOfSentence);
        return calculator(numberSentence.findOperand(), numberSentence.findOperator());
    }

    private int calculator(List<Operand> operands, List<Operator> operators) {
        int sum = OperatorFactory.getOperator("+").calculate(new Operand(0), operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            sum = operators.get(i).calculate(new Operand(sum), operands.get(i + 1));
        }
        return sum;
    }
}
