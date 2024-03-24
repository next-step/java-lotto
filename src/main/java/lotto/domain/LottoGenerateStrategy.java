package lotto.domain;

@FunctionalInterface
public interface LottoGenerateStrategy {

    LottoNumbers generateLottoNumbers();
}

