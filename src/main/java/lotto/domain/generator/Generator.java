package lotto.domain.generator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class Generator {

  private LottoGenerator lottoGenerator;

  public Generator(LottoGenerator lottoGenerator) {
    this.lottoGenerator = lottoGenerator;
  }

  public Generator(List<List<Integer>> input) {
    this(new ManualLottoGenerator(input));
  }

  public Generator(int autoLottoCount) {
    this(new AutoLottoGenerator(autoLottoCount));
  }

  public List<Lotto> generateLottos() {
    return lottoGenerator.generatedLottoList();
  }


  public List<Lotto> composite(Money money) {
    List<Lotto> lottos = generateLottos();
    money.decreaseByManualLottoCount(lottos.size());
    Generator generator = new Generator(money.calculateLottoCount());
    List<Lotto> autoLottos = generator.generateLottos();
    lottos.addAll(autoLottos);
    return lottos;
  }


}
