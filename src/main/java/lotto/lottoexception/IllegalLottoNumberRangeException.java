package lotto.lottoexception;

public class IllegalLottoNumberRangeException extends IllegalArgumentException {

  public IllegalLottoNumberRangeException() {
    super("허용되지 않는 범위의 로또 번호입니다.");
  }
}
