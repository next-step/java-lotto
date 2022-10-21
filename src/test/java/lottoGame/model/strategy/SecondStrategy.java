package lottoGame.model.strategy;

import lottoGame.model.lotto.lottoNumber.DefaultLottoNumber;
import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public class SecondStrategy implements ShuffleStrategy{

    @Override
    public List<LottoNumber> shuffleLottoNum(List<LottoNumber> lottoNumbers) {
        return List.of(
                new DefaultLottoNumber(1),
                new DefaultLottoNumber(2),
                new DefaultLottoNumber(3),
                new DefaultLottoNumber(4),
                new DefaultLottoNumber(5),
                new DefaultLottoNumber(7));
    }
}
