package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.InvalidLottoPurchasePriceException;

public class LottoGame {

  private final List<Lotto> lottos = new ArrayList<>();

  public LottoGame(long money) { // TODO :remove
    this(new Money(money));
  }

  public LottoGame(Money money) { // TODO :remove
    validateMoney(money);
    long cnt = money.value() / Lotto.PRICE.value();
    for (long i = 0; i < cnt; i++) {
      lottos.add(Lotto.issueByAuto());
    }
  }

  public LottoGame(long money, List<int[]> manualLottoList) {
    this(
        new Money(money),
        manualLottoList.stream().map(Lotto::issueByManual).collect(Collectors.toList())
    );
  }

  public LottoGame(Money money, List<Lotto> manualLottoList) {
    validateMoney(money);
    long cnt = money.value() / Lotto.PRICE.value() - manualLottoList.size();
    if (cnt < 0) {
      throw new IllegalArgumentException("구입금액을 이상으로 로또를 발급할 수 없습니다.");
    }
    lottos.addAll(manualLottoList);
    for (long i = 0; i < cnt; i++) {
      lottos.add(Lotto.issueByAuto());
    }
  }

  public List<Lotto> lottos() {
    return lottos;
  }

  public WinningResult winningResult(WinningInfo winningInfo) {
    return new WinningResult(lottos, winningInfo);
  }

  private void validateMoney(Money money) {
    if (money.compareTo(Lotto.PRICE) < 0) {
      throw new InvalidLottoPurchasePriceException();
    }
  }
}
