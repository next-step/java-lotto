package lotto.domain;

import lotto.utility.NumberMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryTickets {
  private List<Lotto> lottoBundle;

  private int budgetToNumberOfPurchase(int budget) {
    return budget/Lotto.PRICE;
  }

  public void purchase(int budget) {
    int numberOfPurchase = budgetToNumberOfPurchase(budget);

    List<Lotto> lottoList = new ArrayList<>();

    for (int i = 0; i < numberOfPurchase; i++) {
      lottoList.add(new Lotto(NumberMaker.makeSixLottoNumber()));
    }

    this.lottoBundle = new ArrayList<>(lottoList);
  }

  public List<Lotto> getLottoBundle() {
    return new ArrayList<>(this.lottoBundle);
  }

}
