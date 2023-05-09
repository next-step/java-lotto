package calculator.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperatorGroup {
  private static final Pattern OPERATOR_PATTERN_COMPILE = Pattern.compile("^[+|\\-|*|/]$");
  private final List<String> operatorList;

  public OperatorGroup(List<String> formulaList) {
    this.operatorList = makeOperatorList(formulaList);
  }

  private List<String> makeOperatorList(List<String> formulaList) {
    return IntStream.range(0, formulaList.size())
        .filter(this::isOddIndex)
        .mapToObj(formulaList::get)
        .map(this::isThrowIllegalArgumentException)
        .collect(Collectors.toList());
  }

  private Boolean isOddIndex(int index) {
    return index % 2 == 1;
  }

  private String isThrowIllegalArgumentException(String strOperator) {
    if(!isOperator(strOperator)) {
      throw new IllegalArgumentException ("옳바른 입력형태가 아닙니다. (사칙 연산자외의 다른 문자가 입력.)");
    }

    return strOperator;
  }

  private Boolean isOperator(String strOperator) {
    return OPERATOR_PATTERN_COMPILE.asMatchPredicate().test(strOperator);
  }

  public List<String> operatorList() {
    return new ArrayList<>(this.operatorList);
  }

  public Queue<String> operatorQueue() {
    return new LinkedList<>(this.operatorList);
  }
}
