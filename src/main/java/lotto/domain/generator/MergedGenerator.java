package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class MergedGenerator implements LottoGenerator {

  private final List<LottoGenerator> generators;

  public MergedGenerator(final List<LottoGenerator> generators) {
    this.generators = generators;
  }

  @Override
  public List<Lotto> generatedLottoList() {
    List<Lotto> lottos = new ArrayList<>();
    for (LottoGenerator lottoGenerator : generators) {
      lottos.addAll(lottoGenerator.generatedLottoList());
    }
    return lottos;
  }
}
