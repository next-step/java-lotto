package lotto.domain;

import java.util.List;

public class Price {

  private static final int PRICE = 1000;

  private Price() {
  }

  public static int buyTickets(int money) {
    return money / PRICE;
  }

  public static int inputMoney(List<LottoRank> lottoRecord) {
    return lottoRecord.size() * PRICE;
  }
}
