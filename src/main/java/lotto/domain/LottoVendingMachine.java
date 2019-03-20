package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleResultView;

public class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1000;

  private NumberGenerator numberGenerator;

  public LottoVendingMachine() {
    this.numberGenerator = new NumberGenerator();
  }

  public LottoVendingMachine(NumberGenerator numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  public List<Lotto> purchaseLotto(Money purchaseAmount) {

    int issueCount = (int)purchaseAmount.amount() / LOTTE_PRICE;

    List<Lotto> lottoList = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {

      Lotto newLotto = new Lotto(numberGenerator.generate());
      lottoList.add(newLotto);
    }
    return lottoList;
  }

  public Money totalWinMoney(List<Lotto> lottoList, List<Number> winNumbers) {

    Money totalWinMoney = new Money(0);
    for (int matchCount = 3; matchCount <= 6; matchCount++) {

      long winCount = winCount(matchCount, lottoList, winNumbers);
      totalWinMoney.add(winMoney(matchCount, winCount));
    }

    return totalWinMoney;
  }

  public Money winMoney(int matchCount, long winCount) {

    Money winMoney;
    switch(matchCount) {
      case 3:
        winMoney = new Money(5000);
        break;
      case 4:
        winMoney = new Money(50000);
        break;
      case 5:
        winMoney = new Money(1500000);
        break;
      case 6:
        winMoney = new Money(2000000000);
        break;
      default:
        throw new IllegalArgumentException();
    }
    System.out.println(winMoney);

    ConsoleResultView.printMatchWinCount(matchCount, winMoney, winCount);
    return winMoney.count(winCount);
  }

  private static long winCount(int matchCount, List<Lotto> lottoList, List<Number> winNumbers) {
    return lottoList.stream()
        .filter(lotto -> lotto.winMatch(winNumbers) == matchCount)
        .count();
  }

  public String yield(Money purchaseMoney, Money winMoney) {

    String yield = winMoney.division(purchaseMoney);

    ConsoleResultView.printYield(yield);
    return yield;
  }
}
