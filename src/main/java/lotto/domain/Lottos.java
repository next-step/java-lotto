package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private Purchase purchase;
  private final List<LottoNumbers> lottos;

  public Lottos(Purchase purchase) {
    this.purchase = purchase;
    this.lottos = generateLottoNumbers();
  }

  public List<LottoNumbers> getLottos() {
    return lottos;
  }

  public List<LottoNumbers> generateLottoNumbers() {
    List<LottoNumbers> lottos = new ArrayList<>();

    for (String manualNumber : purchase.manualNumbers()) {
      lottos.add(new LottoNumbers(manualNumber));
    }
    lottos.addAll(LottoStore.generateAutoLottos(purchase.getAmount()));

    return lottos;
  }
}
