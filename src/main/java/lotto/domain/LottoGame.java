package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceedPurchaseCountException;
import lotto.exception.InvalidLottoPurchasePriceException;

public class LottoGame {

  private final long manualLottoCnt;
  private final List<Lotto> lottos = new ArrayList<>();

  public LottoGame(long money, List<int[]> manualLottoList) {
    this(
        new Money(money),
        manualLottoList.stream().map(Lotto::issueByManual).collect(Collectors.toList())
    );
  }

  public LottoGame(Money money, List<Lotto> manualLottoList) {
    manualLottoCnt = manualLottoList.size();
    validateMoney(money);
    long autoLottoCnt = LottoGame.purchaseCnt(money) - manualLottoList.size();
    validateAutoLottoCnt(autoLottoCnt);
    lottos.addAll(manualLottoList);
    issueLottoByAuto(autoLottoCnt);
  }

  public static long purchaseCnt(Money money) {
    return money.value() / Lotto.PRICE.value();
  }

  public long manualLottoCnt() {
    return manualLottoCnt;
  }

  public long autoLottoCnt() {
    return lottos.size() - manualLottoCnt;
  }

  public List<Lotto> lottos() {
    return lottos;
  }

  public WinningResult winningResult(WinningInfo winningInfo) {
    return new WinningResult(lottos, winningInfo);
  }

  private void issueLottoByAuto(long autoLottoCnt) {
    for (long i = 0; i < autoLottoCnt; i++) {
      lottos.add(Lotto.issueByAuto());
    }
  }

  private void validateMoney(Money money) {
    if (money.compareTo(Lotto.PRICE) < 0) {
      throw new InvalidLottoPurchasePriceException();
    }
  }

  private void validateAutoLottoCnt(long autoLottoCnt) {
    if (autoLottoCnt < 0) {
      throw new ExceedPurchaseCountException();
    }
  }
}
