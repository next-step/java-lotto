package calculator;

public class FormulaCalculator {

    public static Integer calculate(String formula) {
        FormulaElements formulaElements = new FormulaElements(formula);
        int leftOperand = 0;

        while (!formulaElements.isEmpty()) {
            leftOperand = calculate(leftOperand,
                    formulaElements.poll(),
                    OperandParser.parse(formulaElements.poll())
            );
        }

        return leftOperand;
    }

    private static int calculate(int leftOperand, String operator, int rightOperand) {
        return Operator.getOperator(operator)
                .apply(leftOperand, rightOperand);
    }
}
