package lottogame.domain;

import java.util.List;

import lottogame.domain.lotto.LottoNumber;

@FunctionalInterface
public interface LottoNumberGenerationStrategy {
    List<LottoNumber> getNumbers();
}
