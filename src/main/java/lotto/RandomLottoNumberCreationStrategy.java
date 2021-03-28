package lotto;

import static lotto.domain.LottoNumber.LOTTO_NUMBER_POOL;
import static lotto.domain.LottoNumbers.LOTTO_NUMBER_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoNumber;

public class RandomLottoNumberCreationStrategy implements LottoNumberCreationStrategy {

  private static final List<LottoNumber> lottoNumberPool = new ArrayList<>(LOTTO_NUMBER_POOL);
  private static final int BEGIN_COUNT = 0;

  @Override
  public List<LottoNumber> create() {
    Collections.shuffle(lottoNumberPool);
    List<LottoNumber> lottoNumbers = new ArrayList<>(lottoNumberPool.subList(BEGIN_COUNT, LOTTO_NUMBER_COUNT));
    Collections.sort(lottoNumbers);
    return lottoNumbers;
  }
}
