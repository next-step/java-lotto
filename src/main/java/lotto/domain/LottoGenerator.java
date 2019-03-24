package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

  private final static int FROM_INDEX = 0;

  public static Set<LottoNumber> generate() {

    List<LottoNumber> lottoNumbers = IntStream.range(LottoNumber.MINIMUM, LottoNumber.MAXIMUM)
        .mapToObj(LottoNumber::getInstance)
        .collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);

    return new HashSet<>(lottoNumbers.subList(FROM_INDEX, FROM_INDEX + Lotto.NUMBERS_SIZE));
  }
}
