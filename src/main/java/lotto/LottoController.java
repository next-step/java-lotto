package lotto;

import lotto.domain.*;
import lotto.view.InputView;
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

    public void viewResult(Lottos lottos, int[] winLotto, int bonusNumber, Money money) {
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber, lottos);

        ResultView.printLottoResult(lottoRanks);
        ResultView.getYield(lottoRanks, money);
    }
}
