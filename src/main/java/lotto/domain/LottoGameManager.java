package lotto.domain;

import lotto.domain.model.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.config.LottoGameConfig.LOTTO_MAX_NUMBER;
import static lotto.config.LottoGameConfig.LOTTO_MIN_NUMBER;

public class LottoGameManager {
  private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  private LottoGameManager() {}

  public static Lotto newAutoLotto() {
    Collections.shuffle(lottoNumberPool);
    return new Lotto(lottoNumberPool);
  }

  public static Lotto newManualLotto(String[] numbers) {
    return new Lotto(numbers);
  }
}
