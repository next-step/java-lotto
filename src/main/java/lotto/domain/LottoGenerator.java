package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  private static final int LOTTO_SIZE = 6;

  public Lotto generateAutoLotto() {
    List<Integer> numbers = IntStream.rangeClosed(LottoNo.MIN_NUMBER, LottoNo.MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    Collections.shuffle(numbers);
    return new Lotto(numbers.subList(0, LOTTO_SIZE));
  }
} 