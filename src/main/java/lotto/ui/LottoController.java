package lotto.ui;

import lotto.application.LottoResponse;
import lotto.application.LottoResults;
import lotto.application.LottoService;
import lotto.application.WinningLottoRequest;
import lotto.domain.lotto.Lotteries;
import lotto.domain.rank.LottoRanks;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public LottoResponse manual(Lotteries lotteries) {
        return LottoResponse.of(lottoService.buyManual(lotteries));
    }

    public LottoResponse auto(int autoCount) {
        return LottoResponse.of(lottoService.buyAuto(autoCount));
    }

    public int pay(int boughtCount) {
        return lottoService.pay(boughtCount);
    }

    public LottoResults match(WinningLottoRequest winningLottoRequest) {
        LottoRanks lottoRanks =
                lottoService.matchResults(winningLottoRequest.getLotteries(), winningLottoRequest.getWinningLotto());
        return LottoResults.of(lottoRanks);
    }

}
