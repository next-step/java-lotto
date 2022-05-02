package lotto.strategy;

import static lotto.model.LottoNumber.LOTTO_NUMBER_RANGE_END;
import static lotto.model.LottoNumber.LOTTO_NUMBER_RANGE_START;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.LottoNumber;

public class RandomNumberGenerateStrategy implements LottoNumberGenerateStrategy {

  private static final int LIMIT_NUMBER = 6;

  private static final List<LottoNumber> LOTTO_NUMBER_ELEMENTS = IntStream.rangeClosed(
          LOTTO_NUMBER_RANGE_START,
          LOTTO_NUMBER_RANGE_END)
      .mapToObj(LottoNumber::new)
      .collect(Collectors.toList());

  @Override
  public List<LottoNumber> generate() {
    Collections.shuffle(LOTTO_NUMBER_ELEMENTS);
    return LOTTO_NUMBER_ELEMENTS.stream()
        .limit(LIMIT_NUMBER)
        .collect(Collectors.toList());
  }
}
