package calculator.dto;

public class CalculatorExpression {

    private String separator;
    private String formula;

    public CalculatorExpression(String expression, String formula) {
        this.separator = expression;
        this.formula = formula;
    }

    public String getSeparator() {
        return separator;
    }

    public String getFormula() {
        return formula;
    }
}
