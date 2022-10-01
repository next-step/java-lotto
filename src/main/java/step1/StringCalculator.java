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
        List<OperatorType> operatorTypes = new ArrayList<>();

        for (int i = 0; i < parameters.length; i++) {
            distinguishOperandAndOperator(parameters[i], operands, operatorTypes);
        }

        return generateResult(operatorTypes, operands);
    }

    private static void distinguishOperandAndOperator(String operand, List<Operand> operands, List<OperatorType> operatorTypes){
        if (OperatorType.isOperator(operand)) {
            operatorTypes.add(OperatorType.getOperator(operand));
            return;
        }

        operands.add(new Operand(operand));
    }

    private static int generateResult(List<OperatorType> operatorTypes, List<Operand> operands) {
        Iterator<Operand> operandIterator = operands.stream().iterator();
        Iterator<OperatorType> operatorIterator = operatorTypes.iterator();

        int result = operandIterator.next().getOperand();

        while (operatorIterator.hasNext()) {
            Calculator calculator = OperatorFactory.createCalculator(operatorIterator.next().getOperator());
            int secondOperand = operandIterator.next()
                .getOperand();

            result = calculator.calculate(result, secondOperand);
        }

        return result;
    }
}
