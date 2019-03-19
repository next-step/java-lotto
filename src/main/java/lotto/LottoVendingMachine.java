package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.view.ResultView;

public class LottoVendingMachine {

  private static final int LOTTE_PRICE = 1000;

  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 45;

  private static final Money TRHEE_WIN_MONEY = new Money(5000);
  private static final Money FOUR_WIN_MONEY = new Money(50000);
  private static final Money FIVE_WIN_MONEY = new Money(1500000);
  private static final Money SIX_WIN_MONEY = new Money(2000000000);

  public static List<Lotto> purchaseLotto(int purchaseAmount) {

    int issueCount = purchaseAmount / LOTTE_PRICE;

    List<Lotto> lottoList = new ArrayList<>();
    for (int index = 0; index < issueCount; index++) {

      Lotto newLotto = new Lotto(generateLottoNumbers());
      lottoList.add(newLotto);
    }
    return lottoList;
  }

  public static List<Number> generateLottoNumbers() {

    List<Number> numbers = IntStream.range(START_NUMBER, END_NUMBER)
        .mapToObj(Number::new)
        .collect(Collectors.toList());
    Collections.shuffle(numbers);

    List<Number> lotteNumbers = numbers.subList(0, 6);
    ResultView.printIssueLottoNumbers(lotteNumbers);
    return lotteNumbers;
  }

  public static Money totalWinMoney(List<Lotto> lottoList, List<Number> winNumbers) {

    Money totalWinMoney = new Money(0);
    for (int matchIndex = 3; matchIndex <= 6; matchIndex++) {
      totalWinMoney.add(winMoney(matchIndex, lottoList, winNumbers));
    }

    return totalWinMoney;
  }

  private static Money winMoney(int matchCount, List<Lotto> lottoList, List<Number> winNumbers) {

    long winCount = lottoList.stream()
        .filter(lotto -> lotto.winMatch(winNumbers) == matchCount)
        .count();

    Money winMoney = new Money(0);
    switch(matchCount) {
      case 3:
        winMoney = TRHEE_WIN_MONEY;
        break;
      case 4:
        winMoney = FOUR_WIN_MONEY;
        break;
      case 5:
        winMoney = FIVE_WIN_MONEY;
        break;
      case 6:
        winMoney = SIX_WIN_MONEY;
        break;
    }
    ResultView.printMatchWinCount(matchCount, winMoney, winCount);
    return winMoney.count(winCount);
  }

  public static String yield(Money purchaseMoney, Money winMoney) {

    String yield = winMoney.division(purchaseMoney);

    ResultView.printYield(yield);
    return yield;
  }
}
