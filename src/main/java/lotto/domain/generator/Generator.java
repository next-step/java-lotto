package lotto.domain.generator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Generator {

  private LottoGenerator lottoGenerator;

  public Generator(LottoGenerator lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public Generator() {
  }

  public List<Lotto> manualLotto() {
    return lottoGenerator.generatedLottoList();
  }


  public List<Lotto> autoLotto(int calculateLottoCount) {
    return new AutoLottoGenerator(calculateLottoCount).generatedLottoList();
  }

  public List<Lotto> composite(Money money) {
    List<Lotto> lottos = manualLotto();
    money.decreaseByManualLottoCount(lottos.size());
    List<Lotto> autoLottos = autoLotto(money.calculateLottoCount());
    lottos.addAll(autoLottos);
    return lottos;
  }


}
