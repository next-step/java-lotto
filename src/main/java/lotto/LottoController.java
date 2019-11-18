package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public void execute(Money money, List<String> manualLottosNumbers) {
        List<Lotto> lottosM = new ManualLottos(manualLottosNumbers).getManualLottos();
        List<Lotto> lottosA = new AutoLottos(money).getAutoLottos();

        Lottos manualLottos = new LottosMaker().generate(lottosM);
        Lottos autoLottos = new LottosMaker().generate(lottosA);

        manualLottos.addManualLottos(autoLottos.getLottos());
        ResultView.printLottoNumber(manualLottos);

        int[] winLotto = InputView.getWinLotto();
        int bonusNumber = InputView.getBonusNumber();
        Ranks lottoRanks = new Ranks(winLotto, bonusNumber, manualLottos);

        ResultView.printLottoResult(lottoRanks);
        ResultView.getYield(lottoRanks, money);
    }
}
