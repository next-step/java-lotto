package step4.domain;

import step4.dto.LottoInformation;
import step4.dto.LottoResult;

import java.util.List;

public class LottoGame {

    private final LottoSeller autoLottoSeller;
    private final LottoSeller manualLottoSeller;

    public LottoGame(LottoSeller autoLottoSeller, LottoSeller manualLottoSeller) {
        this.autoLottoSeller = autoLottoSeller;
        this.manualLottoSeller = manualLottoSeller;
    }

    public Lottos buy(LottoInformation lottoInformation) {
        LottoPaper lottoPaper = LottoPaper.of(lottoInformation);
        Lottos lottos = manualLottoSeller.lottos(lottoPaper);
        return lottos.add(autoLottoSeller.lottos(lottoPaper));
    }

    public LottoResult result(Lottos lottos, WinningLotto winningLotto) {
        List<WinningRank> winningRanks = WinningRank.findWinningRanks(lottos, winningLotto);
        Money origin = lottos.faceValue();
        Money winning = winningRanks.stream()
                .map(WinningRank::getReward)
                .reduce((x, y) -> x.add(y))
                .orElse(Money.of(0));
        return LottoResult.of(origin, winningRanks, winning);
    }

}
