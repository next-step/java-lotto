package study.step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

  private static final int LOTTO_MIN_NUMBER = 1;
  private static final int LOTTO_MAX_NUMBER = 45;

  private LottoNumbers() {
  }

  public static List<Integer> pick() {
    List<Integer> lottoNumbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());

    Collections.shuffle(lottoNumbers);
    List<Integer> picked = lottoNumbers.subList(0, 5);
    Collections.sort(picked);

    return picked;
  }

}
