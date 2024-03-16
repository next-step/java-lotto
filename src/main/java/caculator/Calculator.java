package caculator;

import caculator.domain.Number;
import caculator.domain.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
  public String readInput() {
    return (new Scanner(System.in)).nextLine();
  }

  public List<Number> extractOperands(String expression) {
    final Pattern pattern = Pattern.compile("[0-9]+");
    final Matcher matcher = pattern.matcher(expression);
    final List<Number> operands = new ArrayList<>();

    while (matcher.find()) {
      operands.add(new Number(matcher.group()));
    }

    return operands;
  }

  public List<Operator> extractOperators(String expression) {
    final Pattern pattern = Pattern.compile("[+\\-*/]");
    final Matcher matcher = pattern.matcher(expression);
    final List<Operator> operators = new ArrayList<>();

    while (matcher.find()) {
      operators.add(Operator.of(matcher.group()));
    }

    return operators;
  }

  public int calculate(List<Number> numbers, List<Operator> operators) {
    Number acc = numbers.get(0);
    for (int i = 1; i < numbers.size(); i++) {
      acc = acc.apply(operators.get(i - 1), numbers.get(i));
    }
    return acc.value();
  }
}
