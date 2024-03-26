package lotto.domain.strategy;

import java.util.Set;

@FunctionalInterface
public interface LottoTicketCreateGenerator {
  Set<Integer> generate();
}
