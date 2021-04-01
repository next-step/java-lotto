package lotto.domain.lotto;

import static lotto.domain.lotto.LottoNumber.LOTTO_NUMBER_POOL;
import static lotto.domain.lotto.LottoNumbers.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomLottoNumberCreationStrategy implements LottoNumberCreationStrategy {

  private static final List<LottoNumber> lottoNumberPool = new ArrayList<>(LOTTO_NUMBER_POOL);
  private static final int BEGIN_COUNT = 0;

  @Override
  public List<LottoNumber> create() {
    Collections.shuffle(lottoNumberPool);
    return new ArrayList<>(lottoNumberPool.subList(BEGIN_COUNT, LOTTO_NUMBER_COUNT));
  }
}
