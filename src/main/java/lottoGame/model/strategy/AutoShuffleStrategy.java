package lottoGame.model.strategy;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.Collections;
import java.util.List;

public class AutoShuffleStrategy implements ShuffleStrategy {
    @Override
    public List<LottoNumber> shuffleLottoNum(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
