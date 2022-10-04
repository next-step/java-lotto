package calculator;

public class FormulaCalculator {

    public static Integer calculate(String formula) {
        return calculate(new FormulaElements(formula));
    }

    private static int calculate(FormulaElements formulaElements) {
        int leftOperand = 0;
        while (!formulaElements.isEmpty()) {
            leftOperand = getOperator(formulaElements)
                    .apply(leftOperand, getOperand(formulaElements));
        }
        return leftOperand;
    }

    private static Operator getOperator(FormulaElements formulaElements) {
        return Operator.getOperator(formulaElements.poll());
    }

    private static int getOperand(FormulaElements formulaElements) {
        return OperandParser.parse(formulaElements.poll());
    }

}
