package lotto.game;

import lotto.LottoNumber;
import lotto.utils.ShuffleNumbers;

import java.util.List;

public class RandomLottoNumberGenerateStrategy implements LottoNumberGenerateStrategy {
    @Override
    public List<LottoNumber> generate() {
        return LottoNumber.toLottoNumbers(ShuffleNumbers.generateLottoNumbers());
    }
}
