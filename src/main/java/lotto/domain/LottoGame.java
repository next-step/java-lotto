package lotto.domain;

import lotto.dto.LottoDto;
import lotto.dto.StatisticsDto;
import lotto.strategy.MakeLottoNumber;

import java.util.List;

public class LottoGame {
    private final Lottos lottos;

    public LottoGame(int buyRound, MakeLottoNumber makeLottoNumber) {
        this.lottos = new Lottos(buyRound, makeLottoNumber);
    }

    public LottoDto getLottos() {
        return new LottoDto(lottos.getLottos());
    }

    public StatisticsDto getResultStatics(String winLottoNumbers, int buyRound){
        Lotto winLotto = new Lotto(winLottoNumbers);
        List<Rank> ranks = lottos.compareWinLotto(winLotto);
        return new StatisticsDto(ranks, buyRound);
    }

}
