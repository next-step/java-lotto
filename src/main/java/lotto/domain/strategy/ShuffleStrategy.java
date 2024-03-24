package lotto.domain.strategy;

import java.util.*;

public class ShuffleStrategy implements LottoTicketCreateGenerator {
  private static final List<Integer> POSSIBLE_LOTTO_NUMBER_CANDIDATES = new ArrayList<>();

  static {
    for (int lottoNumber = LOTTO_MIN_NUMBER; lottoNumber <= LOTTO_MAX_NUMBER; lottoNumber++) {
      POSSIBLE_LOTTO_NUMBER_CANDIDATES.add(lottoNumber);
    }
  }

  @Override
  public Set<Integer> generate() {
    Collections.shuffle(POSSIBLE_LOTTO_NUMBER_CANDIDATES);
    return new HashSet<>(POSSIBLE_LOTTO_NUMBER_CANDIDATES.subList(0, 6));
  }
}
