package domain;

import java.util.Map;
import java.util.function.BiFunction;

public class Operator {

  public static final Map<String, BiFunction<Integer, Integer, Integer>> operatorMap = Map.of(
      "+", (a,b) -> a+b,
      "-", (a,b) -> a-b,
      "*", (a,b) -> a*b,
      "/", (a,b) -> a/b
  );

  public static boolean supportedOperator(String expression){
    return operatorMap.containsKey(expression);
  }
}
