package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
  private static final int LOTTO_SELL_PRICE = 1000;

  private final List<LottoNumbers> lottoNumbers;

  private LottoTicket(List<LottoNumbers> lottoNumbers) {
    this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
  }

  public static LottoTicket toBuy(final int money) {
    int makeTicketCount = money / LOTTO_SELL_PRICE;
    List<LottoNumbers> lottoNumbers = new ArrayList<>(makeTicketCount);
    while (makeTicketCount > 0) {
      lottoNumbers.add(LottoNumbers.generateSixNumbers());
      makeTicketCount--;
    }

    return new LottoTicket(lottoNumbers);
  }

  public int ticketCount() {
    return lottoNumbers.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return "LottoTicket=" + lottoNumbers;
  }
}
