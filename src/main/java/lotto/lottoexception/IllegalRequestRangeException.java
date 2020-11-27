package lotto.lottoexception;

public class IllegalRequestRangeException extends IllegalArgumentException {

  public IllegalRequestRangeException() {
    super("허용 되지 않는 요청 범위 입니다.");
  }
}
