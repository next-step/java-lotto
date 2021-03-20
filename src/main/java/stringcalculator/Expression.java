package stringcalculator;

public class Expression {

  private static final String DELIMITER = ",";

  private final String expression;

  public Expression(String expression) {
    if (expression == null || expression.isEmpty()) {
      expression = "0";
    }
    this.expression = expression;
  }

  public String[] numbers() {
    return expression.split(DELIMITER);
  }
}
