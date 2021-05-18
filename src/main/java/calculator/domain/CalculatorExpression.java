package calculator.domain;

public class CalculatorExpression {
    private String separator;
    private String formula;
    
    public CalculatorExpression(String separator, String formula) {
        this.separator = separator;
        this.formula = formula;
    }

    public String getSeparator() {
        return separator;
    }

    public String getFormula() {
        return formula;
    }
}
