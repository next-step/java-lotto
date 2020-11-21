package lotto.domain;

import static lotto.config.LottoGameConfig.LOTTO_MAX_NUMBER;
import static lotto.config.LottoGameConfig.LOTTO_MIN_NUMBER;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoNumber;

public class LottoGameManager {
  private static final List<LottoNumber> lottoNumberPool = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  private LottoGameManager() {}

  public static Lotto newAutoLotto() {
    Collections.shuffle(lottoNumberPool);
    return new Lotto(lottoNumberPool);
  }
}
