package lottoGame.model.strategy;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class TestShuffleStrategy implements ShuffleStrategy {

    @Override
    public List<LottoNumber> shuffleLottoNum(List<LottoNumber> lottoNumbers) {
        return lottoNumbers;
    }
}
