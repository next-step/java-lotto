package lotto.domain;

@FunctionalInterface
public interface LottoGeneratingStrategy {
    Lotto lotto();
}
