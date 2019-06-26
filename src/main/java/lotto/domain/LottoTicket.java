package lotto.domain;

import java.util.List;
import java.util.Objects;

public class LottoTicket {

  static final int LOTTO_NUMBER_SIZE = 6;
  private final LottoNumber lottoNumber;

  public LottoTicket(LottoNumber lottoNumber) {
    this.lottoNumber = lottoNumber;
  }

  public Rank winNumberSize(List<Integer> winNumber) {
    return lottoNumber.winNumberSize(winNumber);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(lottoNumber, that.lottoNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumber);
  }

  @Override
  public String toString() {
    return lottoNumber.toString();
  }
}
