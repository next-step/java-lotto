package lotto.strategy;

import lotto.LottoNumbers;

public class RandomDrawLottoNumberStrategy implements LotteryStrategy {
    private static final int NUMBER_COUNT = 6;
    @Override
    public LottoNumbers draw(LottoNumbers numbers) {
        numbers.shuffleNumbers();
        return numbers.selectNumbers(NUMBER_COUNT);
    }
}
