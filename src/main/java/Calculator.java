import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Calculator {

  private Map<String, BiFunction<Integer, Integer, Integer>> operatorMap = Map.of(
      "+", (a,b) -> a+b,
      "-", (a,b) -> a-b,
      "*", (a,b) -> a*b,
      "/", (a,b) -> a/b
  );

  public int calculate(String expression) {
    verifyInputIsBlank(expression);
    String[] split = expression.split(" ");

    List<Integer> numbers = Arrays.stream(split).filter(this::isNumber).map(Integer::parseInt).collect(Collectors.toList());
    List<String> strOperators = Arrays.stream(split).filter(this::isOperator).collect(Collectors.toList());
    verifyInputIsAbnormalExpression(numbers, strOperators, split);

    int result = numbers.get(0);
    for(int i = 0 ; i < numbers.size() -1 ; i++){
      result = operatorMap.get(strOperators.get(i)).apply(result, numbers.get(i+1));
    }
    return result;
  }

  private void verifyInputIsAbnormalExpression(List<Integer> numbers, List<String> strOperators, String[] split) {
    if(split.length % 2 == 0){
      throw new IllegalArgumentException();
    }

    if(numbers.size() + strOperators.size() != split.length){
      throw new IllegalArgumentException();
    }
  }

  private void verifyInputIsBlank(String expression) {
    if (expression == null || expression.isBlank()) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isOperator(String operator) {
    Set<String> basicOperators = Set.of("+", "-", "*", "/");
    return basicOperators.contains(operator);
  }

  private boolean isNumber(String number) {
    return number.matches("[0-9]+");
  }


}
