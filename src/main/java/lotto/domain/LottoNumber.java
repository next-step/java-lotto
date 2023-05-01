package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

  private final int value;
  public LottoNumber(int value) {
    this.value = value;
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    if (this.value > lottoNumber.value) {
      return 1;
    }

    if (this.value < lottoNumber.value) {
      return -1;
    }

    return 0;
  }

  public int value() {
    return this.value;
  }
}
