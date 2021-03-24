package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class ManualGenerator implements LottoGenerator {

  private final List<List<Integer>> input;

  public ManualGenerator(List<List<Integer>> input) {
    this.input = input;
  }

  @Override
  public List<Lotto> generatedLottoList() {
    List<Lotto> lottos = new ArrayList<>();
    for (List<Integer> lottoNumbers : input) {
      lottos.add(Lotto.of(lottoNumbers));
    }

    return lottos;
  }

}
