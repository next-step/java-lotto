package lotto.exception;

public class IllegalBonusConditionException extends LottoException {

  public static final String ILLEGAL_BONUS_CONDITION = "보너스 번호가 일치할 수 없는 조건입니다.";

  public IllegalBonusConditionException() {
    super(ILLEGAL_BONUS_CONDITION);
  }
}
