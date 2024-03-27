package lotto.domain;

@FunctionalInterface
public interface LottoGenerateStrategy {

    Lotto generateLotto(int count);
}

