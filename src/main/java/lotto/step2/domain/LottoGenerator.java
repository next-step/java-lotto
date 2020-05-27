package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGenerator {

  private LottoGenerator() {}

  private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(Lotto.MIN_VALUE, Lotto.MAX_VALUE)
                                                              .boxed()
                                                              .collect(toList());

  public static Lotto generateLotto () {
    shuffle(LOTTO_NUMBERS);
    return LOTTO_NUMBERS.stream()
                        .limit(Lotto.SIZE)
                        .collect(collectingAndThen(toList(), Lotto::of));
  }

  public static Lotto generateLotto (String lottoNumbers) {
    return Arrays.stream(lottoNumbers.split(","))
                 .map(Integer::parseInt)
                 .collect(collectingAndThen(toList(), Lotto::of));
  }

}
