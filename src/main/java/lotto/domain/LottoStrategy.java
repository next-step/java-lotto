package lotto.domain;

@FunctionalInterface
public interface LottoStrategy {
  LottoTicket issue();
}
