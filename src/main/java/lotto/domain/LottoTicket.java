package lotto.domain;

import lotto.function.GenerateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
  private static final int LOTTO_SELL_PRICE = 1000;

  private final List<LottoNumbers> list;

  private LottoTicket(List<LottoNumbers> list) {
    this.list = Collections.unmodifiableList(list);
  }

  public static LottoTicket toBuy(final int money, final GenerateNumbers generateNumbers) {
    int makeTicketCount = money / LOTTO_SELL_PRICE;
    List<LottoNumbers> lottoNumbers = new ArrayList<>(makeTicketCount);
    while (makeTicketCount > 0) {
      lottoNumbers.add(LottoNumbers.generateSixNumbers(generateNumbers));
      makeTicketCount--;
    }

    return new LottoTicket(lottoNumbers);
  }

  public int totalMoneySpent() {
    return LOTTO_SELL_PRICE * ticketCount();
  }

  public List<LottoNumbers> getList() {
    return list;
  }

  public int ticketCount() {
    return list.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(list);
  }

  @Override
  public String toString() {
    return "LottoTicket=" + list;
  }
}
