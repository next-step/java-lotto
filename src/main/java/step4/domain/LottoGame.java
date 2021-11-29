package step4.domain;

import step4.dto.LottoInformation;
import step4.dto.LottoResult;

import java.util.List;

public class LottoGame {

    private final LottoSeller lottoSeller;

    public LottoGame(LottoSeller lottoSeller) {
        this.lottoSeller = lottoSeller;
    }

    public Lottos buy(LottoInformation lottoInformation) {
        LottoPaper lottoPaper = LottoPaper.of(lottoInformation);
        return lottoSeller.buy(lottoPaper);
    }

    public LottoResult result(Lottos lottos, WinningLotto winningLotto) {
        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, winningLotto);
        Money origin = lottos.getFaceValue();
        Money winning = winningRanks.stream()
                .map(WinningRank::getReward)
                .reduce((x, y) -> x.add(y))
                .orElse(Money.of(0));
        return LottoResult.of(origin, winningRanks, winning);
    }

}
