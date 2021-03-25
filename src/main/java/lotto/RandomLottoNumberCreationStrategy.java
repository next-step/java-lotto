package lotto;

import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;

public class RandomLottoNumberCreationStrategy implements LottoNumberCreationStrategy {

  private static final List<LottoNumber> lottoNumberPool;
  private static final int BEGIN_COUNT = 0;

  static {
    lottoNumberPool = new ArrayList<>(LottoNumber.MAX);
    for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
      lottoNumberPool.add(new LottoNumber(i));
    }
  }

  @Override
  public List<LottoNumber> create() {
    Collections.shuffle(lottoNumberPool);
    return new ArrayList<>(lottoNumberPool.subList(BEGIN_COUNT, LOTTO_NUMBER_COUNT));
  }
}
