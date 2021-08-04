package lotto.domain;

import java.util.Comparator;
import java.util.Objects;
import lotto.Message.Message;

public class LottoNumber implements Comparator<LottoNumber> {

  private final int number;
  
  public static final int LIMIT_NUMBER = 45;

  public LottoNumber(int number) {
    if(number > LIMIT_NUMBER){
      throw new IllegalArgumentException(Message.MSG_ERROR_LIMIT_LOTTO_NUMBER);
    }
    this.number = number;
  }

  public LottoNumber() {
    number = 0;
  }

  public int getNumber() {
    return this.number;
  }

  @Override
  public int compare(LottoNumber num1, LottoNumber num2) {
    return Integer.compare(num1.getNumber(), num2.getNumber());
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
