package lotto.exception;

public class DuplicatedLottoNumberException extends IllegalArgumentException {

  public DuplicatedLottoNumberException() {
    super("로또번호는 중복된 숫자를 허용하지 않습니다.");
  }
}
