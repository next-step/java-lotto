package lotto.step2.domain.strategy.shufflestrategy;

import lotto.step2.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomShuffleStrategy implements ShuffleStrategy {
    @Override
    public List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        List<LottoNumber> randomLottoNumbers = new ArrayList<>(lottoNumbers);
        Collections.shuffle(randomLottoNumbers);
        Collections.sort(randomLottoNumbers);
        return randomLottoNumbers;
    }
}
