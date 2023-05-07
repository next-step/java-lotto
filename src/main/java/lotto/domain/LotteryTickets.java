package lotto.domain;

import lotto.utility.NumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LotteryTickets {
  private List<Lotto> lottoBundle;

  private int budgetToNumberOfPurchase(int budget) {
    return budget/Lotto.PRICE;
  }

  public void purchase(int budget) {
    int numberOfPurchase = budgetToNumberOfPurchase(budget);

    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < numberOfPurchase; i++) {
      lottoList.add(new Lotto());
    }

    this.lottoBundle = new ArrayList<>(lottoList);
  }

  public List<Lotto> getLottoBundle() {
    return new ArrayList<>(this.lottoBundle);
  }

}
