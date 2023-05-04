package lotto.domain.number;

public class LottoNumber {

  private final int number;

  public LottoNumber(int number) {
    throwIfNotPositiveDigit(number);
    this.number = number;
  }

  private void throwIfNotPositiveDigit(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("로또 번호는 0 또는 음수 일 수 없습니다.");
    }
  }

  public int getNumber() {
    return number;
  }
}
