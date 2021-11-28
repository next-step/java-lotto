package domain;

public class LottoNumber implements Comparable<LottoNumber> {

  public static final int MIN_NUMBER = 1;
  public static final int MAX_NUMBER = 45;
  private static final String LOTTO_NUMBER_OUT_OF_BOUND = "로또번호는 1보다 크고 45보다 작은 정수만 입력할 수 있습니다.";

  private final int number;

  public LottoNumber(int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND);
    }
    this.number = number;
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }

  @Override
  public int compareTo(LottoNumber other) {
    return this.number - other.number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

}
