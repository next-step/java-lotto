package lotto.lottoexception;

public class DuplicatedNumberException extends IllegalArgumentException {

  public DuplicatedNumberException() {
    super("중복된 숫자 입니다.");
  }
}
