package lotto.domain;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generate();
}
