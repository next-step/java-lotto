package lotto.domain;

public class LottoNo {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private final int number;

  private LottoNo(int number) {
    validate(number);
    this.number = number;
  }

  public static LottoNo of(int number) {
    return new LottoNo(number);
  }

  private void validate(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER));
    }
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNo lottoNo = (LottoNo) o;
    return number == lottoNo.number;
  }

  @Override
  public int hashCode() {
    return number;
  }
} 