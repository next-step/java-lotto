package lotto.exception;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoException {

  private static final Pattern TARGET_NUMBER_PATTERN = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");

  public static boolean isNumber(String strNumber) {
    return TARGET_NUMBER_PATTERN.asMatchPredicate().test(strNumber);
  }

  public static void checkLottoType(String strNumber) {
    if (!isNumber(strNumber)) {
      lottoIllegalArgumentException("45이하의 숫자, 콤마, 띄어쓰기로 입력해주세요");
    }
  }

  public static boolean isNotDuplicate(List<Integer> numberList) {
    Set<Integer> numberSet = new HashSet<>(numberList);

    return numberSet.size() != (numberList).size();
  }

  public static void checkDuplicate(List<Integer> numberList) {
    if (isNotDuplicate(numberList)) {
      lottoIllegalArgumentException("로또 번호가 중복입니다.");
    }
  }

  public static void checkDuplicateBonus(List<Integer> numberList, int bonusNumber) {
    List<Integer> newNumberList = new ArrayList<>();

    newNumberList.addAll(numberList);
    newNumberList.add(bonusNumber);

    LottoException.checkDuplicate(newNumberList);
  }

  public static boolean isRightSize(List<Integer> numberList) {

    return numberList.size() != Lotto.LENGTH;
  }

  public static void checkSize(List<Integer> numberList) {
    if (isRightSize(numberList)) {
      lottoIllegalArgumentException("로또 번호가 " + Lotto.LENGTH + "개가 아닙니다.");
    }
  }

  public static void lottoIllegalArgumentException(String message) {
    throw new IllegalArgumentException(message);
  }
}
