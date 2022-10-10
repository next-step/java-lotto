package lottogame.domain.strategy;

import lottogame.domain.lotto.LottoNumbers;

public class FixedNumberPassStrategy implements LottoNumberGenerationStrategy {
    private final LottoNumbers numbers;

    public FixedNumberPassStrategy(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    @Override
    public LottoNumbers getNumbers() {
        return numbers;
    }
}
