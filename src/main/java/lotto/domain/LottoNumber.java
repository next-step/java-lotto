package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{

  private int number;

  public LottoNumber(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    return checkGreaterThanInputValue(lottoNumber);
  }

  private int checkGreaterThanInputValue(LottoNumber lottoNumber) {
    if(this.number < lottoNumber.getNumber()){
      return -1;
    }
    return checkLessThanInputValue(lottoNumber);
  }

  private int checkLessThanInputValue(LottoNumber lottoNumber) {
    if(this.number < lottoNumber.getNumber()){
      return 1;
    }
    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return getNumber() == that.getNumber();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumber());
  }
}
