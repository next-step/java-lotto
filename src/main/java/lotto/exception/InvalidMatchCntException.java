package lotto.exception;

public class InvalidMatchCntException extends IllegalArgumentException {

  public InvalidMatchCntException() {
    super("잘못된 매칭개수가 사용되었습니다.");
  }
}
