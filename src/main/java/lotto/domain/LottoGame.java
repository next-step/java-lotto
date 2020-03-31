package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

  public static final int LOTTO_NO_COUNT = 6;
  public static final List<Integer> CANDIDATE_NUMBERS = IntStream.range(1, 45)
      .boxed()
      .collect(Collectors.toList());

  public LottoGame(List<Integer> lottoNumbers) {
  }

  public static List<Integer> genarateRandomNumbers() {
    return null;
  }
}
