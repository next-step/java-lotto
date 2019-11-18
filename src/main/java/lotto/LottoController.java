package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void execute(Money money, List<String> manualLottosNumbers) {

        Lottos manualLottos = new LottosMaker().generate(manualLottosNumbers);
        Lottos autoLottos = new LottosMaker().generate(money);

        Lottos lottos = new Lottos(manualLottos.addManualLottos(autoLottos.getLottos()));

        ResultView.printLottoNumber(lottos);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber, lottos);

        ResultView.printLottoResult(lottoRanks);
        ResultView.getYield(lottoRanks, money);
    }
}
