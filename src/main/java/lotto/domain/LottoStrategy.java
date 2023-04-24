package lotto.domain;

import java.util.TreeSet;

@FunctionalInterface
public interface LottoStrategy {
  LottoTicket issue();
}
