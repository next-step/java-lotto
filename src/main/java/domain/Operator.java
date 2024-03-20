package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

  ADD("+", (a,b) -> a+b),
  SUBTRACT("-", (a,b) -> a-b),
  MULTIPLY("*", (a,b) -> a*b),
  DIVIDE("/", (a,b) -> a/b);

  final String symbol;
  final BiFunction<Integer, Integer, Integer> calculate;

  Operator(String symbol, BiFunction<Integer, Integer, Integer> calculate) {
    this.symbol = symbol;
    this.calculate = calculate;
  }

  public static boolean supportedOperator(String expression){
    return Arrays.stream(Operator.values())
            .anyMatch(element -> element.symbol.equals(expression));
  }

  public static BiFunction<Integer, Integer, Integer> get(String expression){
    return Arrays.stream(Operator.values())
            .filter(element -> element.symbol.equals(expression))
            .map(e -> e.calculate)
            .findFirst()
            .orElse(null);
  }
}
