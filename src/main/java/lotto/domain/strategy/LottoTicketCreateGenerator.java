package lotto.domain.strategy;

import java.util.Set;

@FunctionalInterface
public interface LottoTicketCreateGenerator {
  int LOTTO_MIN_NUMBER = 1;
  int LOTTO_MAX_NUMBER = 45;

  Set<Integer> generate();
}
