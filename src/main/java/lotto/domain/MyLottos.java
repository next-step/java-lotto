package lotto.domain;

import java.util.List;

public class MyLottos {

  private final Money buyMoney;
  private final List<Lotto> lottos;

  public MyLottos(Money buyMoney, List<Lotto> lottos) {
    this.buyMoney = buyMoney;
    this.lottos = lottos;
  }

  public Money getBuyMoney() {
    return buyMoney;
  }

  public List<Lotto> getLottos() {
    return lottos;
  }

  public String yield(Money totalWinMoney) {
    return totalWinMoney.division(buyMoney);
  }
}
