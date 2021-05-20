package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {

  private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUM, LottoNumber.LOTTO_MAX_NUM)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  private LottoNumbersFactory() {}

  public static LottoNumbers generateNewNumbers() {
    Collections.shuffle(lottoNumberPool);
    List<LottoNumber> selectedNumbers = lottoNumberPool.subList(0, LottoNumbers.NUMBER_COUNT_PER_GAME);
    return new LottoNumbers(selectedNumbers);
  }
}
