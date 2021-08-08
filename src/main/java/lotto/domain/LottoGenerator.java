package lotto.domain;

@FunctionalInterface
public interface LottoGenerator {
    LottoTicket generate();
}