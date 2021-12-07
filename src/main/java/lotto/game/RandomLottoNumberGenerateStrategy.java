package lotto.game;

import lotto.utils.ShuffleNumbers;

public class RandomLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {
    @Override
    public LottoNumbers generate() {
        return new LottoNumbers(ShuffleNumbers.generateLottoNumbers());
    }
}
