package step1;

import java.util.Iterator;
import step1.calculator.Calculator;
import step1.calculator.OperatorFactory;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String OPERATOR_OPERAND_DELIMITER = " ";

    public static int calculate(String text) {
        String[] parameters = text.split(OPERATOR_OPERAND_DELIMITER);
        List<Operand> operands = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int i = 0; i < parameters.length; i++) {
            distinguishOperandAndOperator(parameters[i], operands, operators);
        }

        return generateResult(operators, operands);
    }

    private static void distinguishOperandAndOperator(String operand, List<Operand> operands, List<Operator> operators){
        if (Operator.isOperator(operand)) {
            operators.add(Operator.getOperator(operand));
            return;
        }

        operands.add(new Operand(operand));
    }

    private static int generateResult(List<Operator> operators, List<Operand> operands) {
        Iterator<Operand> operandIterator = operands.stream()
            .iterator();

        int result = operandIterator.next()
            .getOperand();

        Iterator<Operator> operatorIterator = operators.iterator();

        while (operatorIterator.hasNext()) {
            Calculator calculator = OperatorFactory.createCalculator(operatorIterator.next().getOperator());
            int secondOperand = operandIterator.next()
                .getOperand();

            result = calculator.calculate(result, secondOperand);
        }

        return result;
    }
}
