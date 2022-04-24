package calculator.domain;

import calculator.exception.InvalidFormulaException;
import calculator.exception.InvalidNumberStrException;
import calculator.exception.InvalidOperatorException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Calculator {

  private static final String INPUT_DELIMITER = " ";

  public Number calc(String formula) {
    if (isNullOrEmpty(formula)) {
      return new Number(0);
    }

    Iterator<String> numOperIter = splitFormula(formula);
    Number resultNumber = getNumber(numOperIter.next());

    return calcOperators(resultNumber, numOperIter);
  }

  private Iterator<String> splitFormula(String formula) {
    return Arrays.stream(formula.split(INPUT_DELIMITER)).iterator();
  }

  private Number getNumber(String number) {
    return new Number(number);
  }

  private Number calcOperators(Number resultNumber, Iterator<String> numOperIter) {
    try {
      return calcOperator(resultNumber, numOperIter);
    } catch (NoSuchElementException | InvalidNumberStrException | InvalidOperatorException e) {
      throw new InvalidFormulaException(e);
    }
  }

  private Number calcOperator(Number resultNumber, Iterator<String> numOperIter) {
    while (numOperIter.hasNext()) {
      Operator operator = Operator.getOperator(numOperIter.next());
      Number targetNum = new Number(numOperIter.next());

      resultNumber = operator.operate(resultNumber, targetNum);
    }
    return resultNumber;
  }

  private boolean isNullOrEmpty(String formula) {
    return formula == null || formula.isEmpty();
  }

}
