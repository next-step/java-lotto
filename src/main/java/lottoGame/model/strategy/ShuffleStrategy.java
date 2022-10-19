package lottoGame.model.strategy;

import lottoGame.model.lotto.lottoNumber.LottoNumber;

import java.util.List;

public interface ShuffleStrategy {
    List<LottoNumber> shuffleLottoNum(List<LottoNumber> lottoNumbers);
}
