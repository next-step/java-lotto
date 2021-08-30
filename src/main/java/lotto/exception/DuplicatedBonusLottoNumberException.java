package lotto.exception;

public class DuplicatedBonusLottoNumberException extends IllegalArgumentException {

  public DuplicatedBonusLottoNumberException() {
    super("보너스 번호는 당첨번호와 중복될 수 없습니다.");
  }
}
