package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;

public class LottoNumberGenerator {

  private static final int LOTTO_NUMBER_RANGE = 45;

  private final List<Integer> lottos;

  public LottoNumberGenerator(List<Integer> lottoTotalSet) {
    this.lottos = lottoTotalSet;
  }

  public List<Integer> getLottos() {
    return lottos;
  }

  public int getOne(int index) {
    return this.lottos.get(index);
  }

  public static LottoNumberGenerator createLottoNumbers() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for(int i = 1; i <= LOTTO_NUMBER_RANGE; i++) {
      lottoNumbers.add(i);
    }
    return new LottoNumberGenerator(lottoNumbers);
  }

  public static List<Number> from(ManualLottoNumberGenerateStrategy strategy) {
    return sort(strategy.generate());
  }

  public static List<Number> from(AutoLottoNumberGenerateStrategy strategy) {
    return sort(strategy.generate());
  }

  private static List<Number> sort(List<Number> generatedLottoNumber) {
    Collections.sort(generatedLottoNumber);
    return generatedLottoNumber;
  }
}
