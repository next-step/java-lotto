package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

  private final List<LottoNumbers> lottos;

  public Lottos(Amount amount, ManualNumbers manualNumbers) {
    this.lottos = generateLottoNumbers(amount, manualNumbers);
  }

  public List<LottoNumbers> getLottos() {
    return lottos;
  }

  public List<LottoNumbers> generateLottoNumbers(Amount amount, ManualNumbers manualNumbers) {
    List<LottoNumbers> lottos = new ArrayList<>();

    for (String manualNumber : manualNumbers.manualNumbers()) {
      lottos.add(new LottoNumbers(manualNumber));
    }
    lottos.addAll(LottoStore.generateAutoLottos(amount));

    return lottos;
  }
}
