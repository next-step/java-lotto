package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {


  public int calculate(String expression) {
    verifyInputIsBlank(expression);
    String[] split = expression.split(" ");

    List<Integer> numbers = findIntegerFromExpression(split);
    List<String> strOperators = findOperatorFromExpression(split);
    verifyInputIsAbnormalExpression(numbers, strOperators, split);

    int result = numbers.get(0);
    for(int i = 0 ; i < numbers.size() -1 ; i++){
      result = Operator.get(strOperators.get(i)).apply(result, numbers.get(i+1));
    }
    return result;
  }

  private void verifyInputIsAbnormalExpression(List<Integer> numbers, List<String> strOperators, String[] split) {
    if(split.length % 2 == 0){
      throw new IllegalArgumentException("표현식의 숫자와 연산자의 배열이 올바르지 않습니다.");
    }

    if(numbers.size() + strOperators.size() != split.length){
      throw new IllegalArgumentException("표현식에는 숫자와 연산자만 있어야 합니다.");
    }
  }

  private List<Integer> findIntegerFromExpression(String[] expressions){
    return  Arrays.stream(expressions)
        .filter(this::isNumber)
        .map(Integer::parseInt).collect(Collectors.toList());
  }

  private List<String> findOperatorFromExpression(String[] expressions){
    return Arrays.stream(expressions)
        .filter(Operator::supportedOperator).collect(Collectors.toList());
  }

  private void verifyInputIsBlank(String expression) {
    if (expression == null || expression.isBlank()) {
      throw new IllegalArgumentException();
    }
  }

  private boolean isNumber(String number) {
    return number.matches("[0-9]+");
  }


}
