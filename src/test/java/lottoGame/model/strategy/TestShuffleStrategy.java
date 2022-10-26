package lottoGame.model.strategy;

import lottoGame.model.lotto.Lotto;
import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class TestShuffleStrategy implements ShuffleStrategy {

    @Override
    public List<LottoNumber> shuffleLottoNum(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream().limit(Lotto.LOTTO_NUMBER_SIZE).collect(Collectors.toList());
    }
}
