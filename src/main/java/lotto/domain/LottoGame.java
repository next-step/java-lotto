package lotto.domain;

import static lotto.domain.model.LottoBall.LOWER_BOUND;
import static lotto.domain.model.LottoBall.UPPER_BOUND;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.model.LottoBall;

public class LottoGame {

  public static final int LOTTO_NO_COUNT = 6;
  private static final int START_INDEX = 0;

  private Set<LottoBall> lottoBalls;

  public LottoGame() {
    List<Integer> candidates = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
        .boxed()
        .collect(Collectors.toList());

    Collections.shuffle(candidates);

    lottoBalls = candidates.subList(START_INDEX, LOTTO_NO_COUNT)
        .stream()
        .map(LottoBall::new)
        .collect(Collectors.toSet());
  }

  public LottoGame(Set<Integer> lottoNumbers) {
    throwIfInvalid(lottoNumbers);

    lottoBalls = lottoNumbers.stream()
        .map(LottoBall::new)
        .collect(Collectors.toSet());
  }

  private void throwIfInvalid(Set<Integer> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NO_COUNT) {
      throw new IllegalArgumentException("LottoGame should have exactly 6 LottoNos");
    }
  }

  public Set<LottoBall> getLottoBalls() {
    return lottoBalls;
  }

  public int getMatchCount(LottoGame lottoGame) {
    return (int) lottoBalls.stream()
        .filter(lottoGame::contains)
        .count();
  }

  public boolean contains(LottoBall lottoBall) {
    return lottoBalls.contains(lottoBall);
  }
}
