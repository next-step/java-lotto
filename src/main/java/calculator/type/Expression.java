package calculator.type;


import java.util.List;
import java.util.stream.IntStream;

import static calculator.util.TypeChecker.isNumeric;
import static calculator.util.TypeChecker.isOperatorType;

public class Expression {

  List<String> splitExpression;

  public static Expression valueOf(String expression) {
    return new Expression(expression);
  }

  private Expression(String expression) {
    if (expression == null || expression.isEmpty()) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    List<String> splitExpression = List.of(expression.split(" "));

    if (splitExpression.size() < 3 || splitExpression.size() % 2 == 0) {
      throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
    }

    IntStream.range(0, splitExpression.size())
        .filter(i ->
            (i % 2 == 0 && !isNumeric(splitExpression.get(i))) ||
                (i % 2 != 0 && !isOperatorType(splitExpression.get(i)))
        )
        .findFirst()
        .ifPresent(i -> {
          throw new IllegalArgumentException("유효하지 않은 표현식입니다.");
        });

    this.splitExpression = splitExpression;
  }


  public int run() {
    int res = Integer.parseInt(splitExpression.get(0));

    for (int i = 1; i < splitExpression.size() - 1; i += 2) {
      res = OperatorType.fromSymbol(splitExpression.get(i)).execute(res, Integer.parseInt(splitExpression.get(i + 1)));
    }

    return res;
  }

}
