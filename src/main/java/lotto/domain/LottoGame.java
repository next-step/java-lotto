package lotto.domain;

import static lotto.domain.LottoNo.LOWER_BOUND;
import static lotto.domain.LottoNo.UPPER_BOUND;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

  public static final int LOTTO_NO_COUNT = 6;
  private static final int START_INDEX = 0;

  private Set<LottoNo> lottoNos;

  public LottoGame() {
    this(genarateRandomNumbers());
  }

  public LottoGame(Set<Integer> lottoNumbers) {
    throwIfInvalid(lottoNumbers);

    lottoNos = lottoNumbers.stream()
        .map(LottoNo::new)
        .collect(Collectors.toSet());
  }

  public Set<LottoNo> getLottoNos() {
    return lottoNos;
  }

  public static Set<Integer> genarateRandomNumbers() {
    List<Integer> candidates = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
        .boxed()
        .collect(Collectors.toList());

    Collections.shuffle(candidates);

    return new HashSet<>(candidates.subList(START_INDEX, LOTTO_NO_COUNT));
  }

  public int getMatchCount(LottoGame lottoGame) {
    return (int) lottoNos.stream()
        .filter(lottoNo -> lottoGame.lottoNos.contains(lottoNo))
        .count();
  }

  private void throwIfInvalid(Set<Integer> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NO_COUNT) {
      throw new IllegalArgumentException("LottoGame should have exactly 6 LottoNos");
    }
  }
}
