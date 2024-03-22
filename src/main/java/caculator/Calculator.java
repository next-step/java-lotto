package caculator;

import caculator.domain.Number;
import caculator.domain.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

  private final Pattern NUMBER = Pattern.compile("[0-9]+");
  private final Pattern OPERATOR = Pattern.compile("[+\\-*/]");

  public List<Number> extractOperands(String expression) {
    final Matcher matcher = NUMBER.matcher(expression);
    final List<Number> operands = new ArrayList<>();

    while (matcher.find()) {
      operands.add(new Number(matcher.group()));
    }

    return operands;
  }

  public List<Operator> extractOperators(String expression) {
    final Matcher matcher = OPERATOR.matcher(expression);
    final List<Operator> operators = new ArrayList<>();

    while (matcher.find()) {
      operators.add(Operator.of(matcher.group()));
    }

    return operators;
  }

  public Number calculate(List<Number> numbers, List<Operator> operators) {
    final AtomicInteger index = new AtomicInteger();
    final int SKIP_FIRST = 1;
    
    return numbers.subList(SKIP_FIRST, numbers.size()).stream()
            .reduce(numbers.get(0), (acc, cur) -> acc.apply(operators.get(index.getAndIncrement()), cur));
  }
}
