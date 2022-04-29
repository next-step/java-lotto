package lotto.exception;

public class LottoRewordNotExistException extends RuntimeException {
  private static final String EXCEPTION_MESSAGE = " 에 대한 상금이 정의되지 않았습니다.";

  public LottoRewordNotExistException(int matchCount) {
    super(matchCount + EXCEPTION_MESSAGE);
  }
}
