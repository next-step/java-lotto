package step3.exception;

public class DuplicatedLottoNumber extends RuntimeException {

  public DuplicatedLottoNumber(String duplicatedErrorMessage) {
    super(duplicatedErrorMessage);
  }
}
