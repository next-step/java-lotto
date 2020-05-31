package lotto.step4.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGenerator {

  private static final String DELIMITER = ",";
  private static final List<LottoNumber> LOTTO_NUMBERS;

  static {
    LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                             .boxed()
                             .map(LottoNumber::valueOf)
                             .collect(toList());
  }

  private LottoGenerator() {}

  public static Lotto generateLotto () {
    shuffle(LOTTO_NUMBERS);
    return LOTTO_NUMBERS.stream()
                        .limit(Lotto.SIZE)
                        .collect(collectingAndThen(toList(), Lotto::of));
  }

  public static Lotto generateLotto (String lottoNumbers) {
    return Arrays.stream(lottoNumbers.split(DELIMITER))
                 .map(String::trim)
                 .map(LottoNumber::valueOf)
                 .collect(collectingAndThen(toList(), Lotto::ofDirect));
  }

}
