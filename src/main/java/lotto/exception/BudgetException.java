package lotto.exception;

import lotto.domain.Lotto;

import java.util.regex.Pattern;

public class BudgetException {
  private static final Pattern BUDGET_PATTERN = Pattern.compile("^[1-9][0-9]+$");

  public static boolean isNumber(String strNumber) {
    return BUDGET_PATTERN.asMatchPredicate().test(strNumber);
  }

  public static int checkIllegalArgumentException(String strNumber) {
    if (!isNumber(strNumber)) {
      throw new IllegalArgumentException("1 이상의 숫자만 입력해주세요");
    }

    return Integer.parseInt(strNumber);
  }

  public static void checkScale(int budget) {
    if (budget < Lotto.PRICE) {
      throw new IllegalArgumentException("금액이 로또 가격보다 낮습니다.");
    }
  }
}
