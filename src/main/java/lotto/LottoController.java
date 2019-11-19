package lotto;

import lotto.domain.*;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public Lottos execute(Money money, List<String> manualLottosNumbers) {
        Lottos manualLottos = new LottosMaker().generate(manualLottosNumbers);
        Lottos autoLottos = new LottosMaker().generate(money);
        Lottos lottos = new Lottos(manualLottos.addManualLottos(autoLottos.getLottos()));

        ResultView.printLottoNumber(lottos);
        return lottos;
    }

    public WinningRank applyRank(int[] winLotto, int bonusNumber) {
        return new WinningRank(winLotto, bonusNumber);
    }

    public void viewResult(Lottos lottos, WinningRank winningRank, Money money) {

        Ranks lottoRanks = new Ranks(winningRank, lottos);

        ResultView.printLottoResult(lottoRanks);
        ResultView.getYield(lottoRanks, money);
    }
}
