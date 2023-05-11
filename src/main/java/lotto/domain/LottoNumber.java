package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

  private final int value;
  public LottoNumber(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    return Integer.compare(value, lottoNumber.value);
  }

  public int value() {
    return this.value;
  }
}
