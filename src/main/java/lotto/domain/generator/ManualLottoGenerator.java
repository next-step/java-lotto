package lotto.domain.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class ManualLottoGenerator implements LottoGenerator {

  private final List<List<Integer>> input;
  private Money money;

  public ManualLottoGenerator(final List<List<Integer>> input,Money money) {
    this.input = input;
    this.money = money;
  }

  @Override
  public List<Lotto> generatedLottoList() {
    List<Lotto> lottos = new ArrayList<>();
    for (List<Integer> lottoNumbers : input) {
      lottos.add(Lotto.of(lottoNumbers));
    }
    money.decreaseByLottoCount(lottos.size());
    return lottos;
  }

}
