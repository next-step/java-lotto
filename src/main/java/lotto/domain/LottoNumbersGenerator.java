package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

  private static final List<LottoNumber> CANDIDATE_LOTTO_NUMBERS = initCandidateLottoNumbers();

  public static List<LottoNumber> generateByRandom() {
    Collections.shuffle(CANDIDATE_LOTTO_NUMBERS);
    return new ArrayList<>(CANDIDATE_LOTTO_NUMBERS.subList(0, Lotto.NUMBER_SIZE));
  }

  private static List<LottoNumber> initCandidateLottoNumbers() {
    return IntStream.rangeClosed(LottoNumber.MIN, LottoNumber.MAX)
        .mapToObj(LottoNumber::new).collect(Collectors.toList());
  }
}
