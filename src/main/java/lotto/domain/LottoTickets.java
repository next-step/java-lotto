package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private static final int PRICE_PER_LOTTO = 1000;
  private final List<Lotto> lottoTickets;

  public LottoTickets(int numberLottos) {
    lottoTickets = new ArrayList<>();
    for (int i = 0; i < numberLottos; i++) {
      lottoTickets.add(new Lotto());
    }
  }

  public static LottoTickets of(int price) {
    return new LottoTickets(price / PRICE_PER_LOTTO);
  }

  public int size() {
    return lottoTickets.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Lotto lotto : lottoTickets) {
      sb.append(lotto.toString()).append("\n");
    }
    return sb.toString();
  }
}
