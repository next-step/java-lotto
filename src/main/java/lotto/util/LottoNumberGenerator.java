package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {

  private static final int LOTTO_NUMBER_RANGE = 45;
  private final List<Integer> lottos;

  public LottoNumberGenerator(List<Integer> lottoTotalSet) {
    this.lottos = lottoTotalSet;
  }

  public List<Integer> getLottos() {
    return lottos;
  }

  public int getOne(int i) {
    return this.lottos.get(i);
  }

  public static LottoNumberGenerator createLottoNumbers() {
    List<Integer> lottoNumbers = new ArrayList<>();
    for(int i = 1; i <= LOTTO_NUMBER_RANGE; i++) {
      lottoNumbers.add(i);
    }
    return new LottoNumberGenerator(lottoNumbers);
  }

}
