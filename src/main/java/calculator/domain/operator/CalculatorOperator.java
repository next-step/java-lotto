package calculator.domain.operator;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CalculatorOperator {
  PLUS("+"),
  MINUS("-"),
  DIVIDE("%"),
  MULTIPLY("*");


  CalculatorOperator(String icon) {
    this.icon = icon;
  }
  private final String icon;

  public String getIcon() {
    return icon;
  }

  private static final Map<String, CalculatorOperator> iconMap = Collections.unmodifiableMap (
      Stream.of(CalculatorOperator.values())
          .collect(Collectors.toMap(CalculatorOperator::getIcon, Function.identity()))
  );

  public static CalculatorOperator findByIcon (String icon) {
    return iconMap.get(icon);
  }
}
