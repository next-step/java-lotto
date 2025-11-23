package lotto.domain.game;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.LottoNumber;

public class Random {

  private static final int MIN = 1, MAX = 45;
  private static final int LOTTO_NUMBER_COUNT = 6;
  private static List<Integer> numbers = IntStream.rangeClosed(MIN, MAX)
      .boxed()
      .collect(Collectors.toList());
  public static List<LottoNumber> generate() {
    Collections.shuffle(numbers);
    return numbers.subList(0, LOTTO_NUMBER_COUNT).stream()
        .sorted()
        .map(LottoNumber::of)
        .toList();
  }
}