package lotto.domain;

import lotto.domain.place.LottoPlaces;
import lotto.function.GenerateNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {
  private static final int LOTTO_PRICE = 1_000;

  private final List<LottoNumbers> values;

  private LottoTicket(List<LottoNumbers> values) {
    this.values = Collections.unmodifiableList(values);
  }

  public static LottoTicket toBuy(final int money, final GenerateNumbers generateNumbers) {
    final int makeTicketCount = money / LOTTO_PRICE;
    List<LottoNumbers> lottoNumbers = new ArrayList<>(makeTicketCount);
    for (int i = 0; i < makeTicketCount; i++) {
      lottoNumbers.add(LottoNumbers.generateSixNumbers(generateNumbers));
    }
    return new LottoTicket(lottoNumbers);
  }

  public LottoPlaces getMatchedLottoPlaces(LottoWiningNumbers lottoWiningNumbers, LottoBonusBall lottoBonusBall) {
    LottoPlaces lottoPlaces = LottoPlaces.create();
    for (LottoNumbers lottoNumbers : values) {
      int countOfMatch = lottoWiningNumbers.countOfMatch(lottoNumbers);
      boolean matchBonus = lottoBonusBall.isMatch(lottoNumbers);
      lottoPlaces = lottoPlaces.record(countOfMatch, matchBonus);
    }
    return lottoPlaces;
  }

  public int totalSpentMoney() {
    return LOTTO_PRICE * ticketCount();
  }

  public List<LottoNumbers> getValues() {
    return values;
  }

  public int ticketCount() {
    return values.size();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoTicket that = (LottoTicket) o;
    return Objects.equals(values, that.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    return "LottoTicket=" + values;
  }
}
