package step3.exception;

public class DuplicatedLottoNumberException extends RuntimeException {

  public DuplicatedLottoNumberException(String duplicatedErrorMessage) {
    super(duplicatedErrorMessage);
  }
}
