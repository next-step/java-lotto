package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.view.InputView;
import lotto.view.ResultView;

class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1000;

  private InputView inputView;
  private NumberGenerator numberGenerator;

  LottoVendingMachine() {
    this.inputView = new InputView();
    this.numberGenerator = new NumberGenerator();
  }

  LottoVendingMachine(InputView inputView, NumberGenerator numberGenerator) {
    this.inputView = inputView;
    this.numberGenerator = numberGenerator;
  }

  String game() {

    Money purchaseMoney = inputView.inputPurchaseAmount();
    List<Lotto> purchaseLottoList = purchaseLotto(purchaseMoney);

    List<Number> winNumber = inputView.inputWinNumbers();

    ResultView.printResultTitle();

    Money winMoney = totalWinMoney(purchaseLottoList, winNumber);
    return yield(purchaseMoney, winMoney);
  }

  List<Lotto> purchaseLotto(Money purchaseAmount) {

    int issueCount = (int)purchaseAmount.amount() / LOTTE_PRICE;

    List<Lotto> lottoList = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {

      Lotto newLotto = new Lotto(numberGenerator.generate());
      lottoList.add(newLotto);
    }
    return lottoList;
  }

  Money totalWinMoney(List<Lotto> lottoList, List<Number> winNumbers) {

    Money totalWinMoney = new Money(0);
    for (int matchCount = 3; matchCount <= 6; matchCount++) {

      long winCount = winCount(matchCount, lottoList, winNumbers);
      totalWinMoney.add(winMoney(matchCount, winCount));
    }

    return totalWinMoney;
  }

  Money winMoney(int matchCount, long winCount) {

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

    ResultView.printMatchWinCount(matchCount, winMoney, winCount);
    return winMoney.count(winCount);
  }

  private static long winCount(int matchCount, List<Lotto> lottoList, List<Number> winNumbers) {
    return lottoList.stream()
        .filter(lotto -> lotto.winMatch(winNumbers) == matchCount)
        .count();
  }

  static String yield(Money purchaseMoney, Money winMoney) {

    String yield = winMoney.division(purchaseMoney);

    ResultView.printYield(yield);
    return yield;
  }
}
