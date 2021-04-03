package step2.exception;

public class DuplicatedLottoNumber extends RuntimeException {

  public DuplicatedLottoNumber(String duplicatedErrorMessage) {
    super(duplicatedErrorMessage);
  }
}
