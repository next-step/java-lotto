package lotto.lottoexception;

public class RemainBudgetException extends IllegalArgumentException {

  public RemainBudgetException() {
    super("충분하지 않은 잔액입니다.");
  }
}
