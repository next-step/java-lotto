package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private List<Lotto> lottos = new ArrayList<>();

  public Lottos(Quantity quantity) {
    makeLottos(quantity);
  }

  public Lottos(List<Lotto> purchasedLottos) {
    lottos = purchasedLottos;
  }

  private void makeLottos(Quantity quantity) {
    for (int i = 0; i < quantity.getValue(); i++) {
      lottos.add(new Lotto());
    }
  }

  public Quantity getQuantity() {
    return new Quantity(lottos.size());
  }

  public List<Lotto> getPurchasedLotto() {
    return lottos;
  }

  public int getSameNumberCount(Lotto lastWeekWinLotto, int boundaryCount) {
    return (int) lottos.stream()
        .map(lotto -> lotto.countSameNumber(lastWeekWinLotto))
        .filter(value -> value == boundaryCount)
        .count();
  }

}
