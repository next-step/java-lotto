package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputConverter {
  private static final Pattern TARGET_NUMBER_PATTERN = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");

  public List<Integer> convertNumberToList(String targetNumber) {
    List<Integer> numberList = Arrays.stream(targetNumber.split(", "))
          .map(this::isThrowIllegalArgumentException)
          .collect(Collectors.toList());

    isSizeSix(numberList);
    isDuplication(numberList);

    return numberList;
  }

  public void isDuplication(List<Integer> numberList) {
    Set<Integer> numSet = new HashSet<>(numberList);
    if(numSet.size()!= numberList.size()){
      throw new IllegalArgumentException("로또 번호 중 중복된 숫자가 있습니다.");
    }
  }

  public void isSizeSix(List<Integer> numberList) {
    if(numberList.size() != 6) {
      throw new IllegalArgumentException("로또 번호 6개를 입력하세요");
    }
  }

  private boolean isNumber(String strNumber) {
    return TARGET_NUMBER_PATTERN.asMatchPredicate().test(strNumber);
  }

  private int isThrowIllegalArgumentException(String strNumber) {

      if(!isNumber(strNumber)){
        throw new IllegalArgumentException("45이하의 숫자, 콤마, 띄어쓰기로 입력해주세요");
      }
      return Integer.parseInt(strNumber);
  }
}
