package stringCalculator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {

  private static final int ELEMENT_SEQUENCE = 2;

  private Parser() {}

  public static Expression parse(String input) {
    List<String> elements = Arrays.asList(input.split(" "));
    List<Operator> operators = new ArrayList<>();
    List<Number> numbers = new ArrayList<>();

    for (int numberIndex = 0, operatorIndex = 1; numberIndex < elements.size(); numberIndex += ELEMENT_SEQUENCE, operatorIndex += ELEMENT_SEQUENCE) {
      numbers.add(new Number(elements.get(numberIndex)));
      operators.add(Operator.from(elements.get(operatorIndex)));
    }

    if (numbers.size() <= operators.size()) {
      throw new IllegalArgumentException(String.format("마지막은 항상 피연산자로 끝나야 합니다. 마지막에 입력된 값 : %s", elements.get(elements.size() - 1)));
    }

    return new Expression(operators, numbers);
  }
}
