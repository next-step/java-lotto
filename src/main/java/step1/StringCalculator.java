package step1;

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

    private static int generateResult(List<Operator> operators, List<Operand> operand) {
        int result = 0;

        for (int i = 0; i < operators.size(); i++) {
            Calculator calculator = OperatorFactory.createCalculator(operators.get(i).getOperator());
            result = calculator.calculate(operand.get(i).getOperand(), operand.get(i+1).getOperand());
            operand.set(i+1, new Operand(String.valueOf(result)));
        }

        return result;
    }
}
