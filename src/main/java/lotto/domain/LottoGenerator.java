package lotto.domain;

@FunctionalInterface
public interface LottoGenerator {
    Lotto generate();
}
