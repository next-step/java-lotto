package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGroup {
  private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]+$");
  private final List<String> numberList;

  public NumberGroup(List<String> formulaList) {
    this.numberList = this.makeNumberList(formulaList);
  }

  private List<String> makeNumberList(List<String> formulaList) {
    return IntStream.range(0, formulaList.size())
        .filter(this::isEvenIndex)
        .mapToObj(formulaList::get)
        .map(this::isThrowIllegalArgumentException)
        .collect(Collectors.toList());
  }

  private Boolean isEvenIndex(int index) {
    return index % 2 == 0;
  }

  private String isThrowIllegalArgumentException(String strNumber) {
    if(!this.isNumber(strNumber)) {
      throw new IllegalArgumentException ("옳바른 입력형태가 아닙니다. (숫자외의 다른 문자가 입력.)");
    }

    return strNumber;
  }

  private Boolean isNumber(String strNumber) {
    return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(strNumber);
  }

  public List<String> numberList() {
    return new ArrayList<>(this.numberList);
  }
}
