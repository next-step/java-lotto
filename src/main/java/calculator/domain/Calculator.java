package calculator.domain;

public class Calculator {
    public static void calculateWholeFormula(ParsedFormula parsedFormula) {
        for (int currentPosition = 1; currentPosition < parsedFormula.getLength(); currentPosition += 2) {
            String operator = parsedFormula.getOperator(currentPosition);
            int operand = parsedFormula.getOperand(currentPosition + 1);

            parsedFormula.updateCurrentResult(Operator.calculate(operator, parsedFormula.getCurrentResult(), operand));
        }
    }
}
