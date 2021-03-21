package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class DefaultGenerator implements LottoGenerator {

  private final AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
  private final List<List<Integer>> input;


  public DefaultGenerator(List<List<Integer>> input) {
    this.input = input;
  }

  @Override
  public List<Lotto> generatedLottoList(Money money) {
    List<Lotto> lottos = new ArrayList<>();
    for (List<Integer> lottoNumbers : input) {
      lottos.add(Lotto.of(lottoNumbers));
      money.decrease();
    }
    lottos.addAll(autoLottoGenerator.generatedLottoList(money));
    return lottos;
  }
}
