package lotto.exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoException {

  private static final Pattern TARGET_NUMBER_PATTERN = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");

  public static boolean isNumber(String strNumber) {
    return TARGET_NUMBER_PATTERN.asMatchPredicate().test(strNumber);
  }

  public static int checkIllegalArgumentException(String strNumber) {
    if(!isNumber(strNumber)) {
      throw new IllegalArgumentException("45이하의 숫자, 콤마, 띄어쓰기로 입력해주세요");
    }

    return Integer.parseInt(strNumber);
  }

  public static void checkSize(List<Integer> numberList) {
    Set<Integer> numberSet = new HashSet<>(numberList);

    if(numberSet.size() != (numberList).size() || numberSet.size() != 6) {
      throw new IllegalArgumentException("로또 번호가 중복 혹은 6개가 아닙니다.");
    }
  }
}
