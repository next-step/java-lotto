package lotto.domain;

import java.util.List;

public class LottoStore {

  private static final int LOTTOPRICE = 1000;

  public Lottos auto(int amount) {
    int lottoCount = this.calculateLottoCount(amount);
    return LottoMachine.sell(lottoCount);
  }
  // 이 메서드를 사용하는 클라이언트 입장에서는 인자값을 한번에 알아보기 힘들겠다.
  public Lottos auto(int amount, int manualSize) {
    int lottoCount = this.calculateLottoCount(amount);
    return LottoMachine.sell(lottoCount - manualSize);
  }

  private int calculateLottoCount(int amount) {
    return amount / LOTTOPRICE;
  }

  public Lottos manual(List<String> manualStringLottoNumber) {
    return LottoMachine.manualLottos(manualStringLottoNumber);
  }
}
