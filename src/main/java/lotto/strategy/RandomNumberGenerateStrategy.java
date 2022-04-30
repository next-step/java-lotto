package lotto.strategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumberGenerateStrategy implements NumberGenerateStrategy{

  private static final int LOTTO_NUMBER_RANGE_START = 1;
  private static final int LOTTO_NUMBER_RANGE_END = 45;
  private static final int LIMIT_ONE_NUMBER = 1;
  private static final int ONE_NUMBER_INDEX = 0;

  private static final List<Integer> lottoNumberElements = IntStream.rangeClosed(LOTTO_NUMBER_RANGE_START,
          LOTTO_NUMBER_RANGE_END)
      .boxed()
      .collect(Collectors.toList());

  @Override
  public int generate() {
    Collections.shuffle(lottoNumberElements);
    return lottoNumberElements.stream()
        .limit(LIMIT_ONE_NUMBER)
        .collect(Collectors.toList())
        .get(ONE_NUMBER_INDEX);
  }
}
