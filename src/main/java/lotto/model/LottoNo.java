package lotto.model;

import java.util.Objects;
import lotto.exception.LottoNegativeException;

public class LottoNo {
  private Integer value;

  public LottoNo(Integer value) {
    valid(value);
    this.value = value;
  }

  private void valid(Integer value) {
    if(value < 0) {
      throw new LottoNegativeException();
    }
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
    return Objects.equals(value, lottoNo.value);
  }
  @Override
  public int hashCode() {
    return Objects.hash(value);
  }


  @Override
  public String toString() {
    return value.toString();
  }
}
