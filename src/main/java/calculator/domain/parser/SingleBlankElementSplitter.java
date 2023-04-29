package calculator.domain.parser;

public class SingleBlankElementSplitter implements CalculatorElementSplitter {
  @Override
  public String[] split(String expression) {
    return expression.split(" ");
  }
}
