package lotto.domain.lottogenerator;

import lotto.domain.Lotto;

public class ManualLottoGenerator implements LottoGenerator {

    private final String[] numbers;

    public ManualLottoGenerator(String[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto get() {
        return Lotto.from(numbers);
    }
}
