package lotto.validation;

import lotto.domain.Lotto;

import java.util.regex.Pattern;

public class BudgetValidation {
  private static final Pattern BUDGET_PATTERN = Pattern.compile("^[1-9][0-9]+$");

  public static boolean isNumber(String strNumber) {
    return BUDGET_PATTERN.asMatchPredicate().test(strNumber);
  }

  public static void checkIntType(String strNumber) {
    if (!isNumber(strNumber)) {
      budgetIllegalArgumentException("1 이상의 숫자만 입력해주세요");
    }
  }

  public static void checkScale(int budget) {
    if (budget < Lotto.PRICE) {
      budgetIllegalArgumentException("금액이 로또 가격보다 낮습니다.");
    }
  }

  public static void budgetIllegalArgumentException(String message) {
    throw new IllegalArgumentException(message);
  }
}
