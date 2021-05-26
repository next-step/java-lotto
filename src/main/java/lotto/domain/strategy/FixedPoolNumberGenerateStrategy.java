package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedPoolNumberGenerateStrategy implements NumberGenerateStrategy {

  private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUM, LottoNumber.LOTTO_MAX_NUM)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  @Override
  public LottoNumbers generateNewNumbers() {
    Collections.shuffle(lottoNumberPool);
    List<LottoNumber> selectedNumbers = lottoNumberPool.subList(0, LottoNumbers.NUMBER_COUNT_PER_GAME);
    return new LottoNumbers(selectedNumbers);
  }
}
