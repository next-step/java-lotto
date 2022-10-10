package domain;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

  List<Integer> numbers = new ArrayList<>();
  List<String> operators = new ArrayList<>();

  public int calculate(String question) {
    QuestionValidation.validateQuestion(question);
    String[] numsAndOperators = splitString(question);
    extractNumbers(numsAndOperators);
    extractOperators(numsAndOperators);
    int result = numbers.get(0);
    int ARRAY_LENGTH = operators.size();
    for (int i = 0; i < ARRAY_LENGTH; i++) {
      result = operate(operators.get(i), result, numbers.get(i + 1));
    }
    return result;
  }

  private String[] splitString(String question) {
    return question.split(" ");
  }

  private void extractNumbers(String[] question) {
    for (int i = 0; i < question.length; i += 2) {
      this.numbers.add(Integer.parseInt(question[i]));
    }
  }

  private void extractOperators(String[] question) {
    for (int i = 1; i < question.length; i += 2) {
      this.operators.add(question[i]);
    }
  }

  private int operate(String operator, int num1, int num2) {
    if (operator.equals("+")) {
      return plus(num1, num2);
    }
    if (operator.equals("-")) {
      return minus(num1, num2);
    }
    if (operator.equals("*")) {
      return multiply(num1, num2);
    }
    if (operator.equals("/")) {
      return divide(num1, num2);
    }
    throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
  }

  private int plus(int num1, int num2) {
    return num1 + num2;
  }

  private int minus(int num1, int num2) {
    return num1 - num2;
  }

  private int multiply(int num1, int num2) {
    return num1 * num2;
  }

  private int divide(int num1, int num2) {
    return num1 / num2;
  }

}
