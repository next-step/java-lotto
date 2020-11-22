package lotto.lottoexception;

public class InvalidLottoFormatException extends IllegalArgumentException {

  public InvalidLottoFormatException() {
    super("로또 번호 묶음 규칙을 따르고 있지 않습니다.");
  }
}
