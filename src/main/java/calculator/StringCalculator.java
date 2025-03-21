package calculator;

import java.util.List;
import java.util.Scanner;

public class StringCalculator {

  public static int calculate(String expression) {
    List<String> tokens = splitExpression(expression);
    int value = Integer.parseInt(tokens.get(0));

    for(int index=1; index<tokens.size(); index+=2) {
      String operator = tokens.get(index);
      int operand = Integer.parseInt(tokens.get(index+1));
      Operation operation = OperationFactory.getOperation(operator);
      value = operation.operate(value, operand);
    }
    return value;
  }

  private static List<String> splitExpression(String expression) {
    if(expression == null || expression.isEmpty()) {
      throw new IllegalArgumentException("입력값이 null이거나 빈 공백 문자입니다.");
    }
    return List.of(expression.split(" "));
  }


  public static void main(String[] args) {
    System.out.println("계산할 식을 입력하세요.");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    scanner.close();

    System.out.println(StringCalculator.calculate(input));
  }
}
