package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void lottoGameStart() {
        int paidMoney = InputView.getMoney();
        int manualLottoCount = InputView.getManualLottoCount();

        Lottos manualLottos = InputView.getLottos(manualLottoCount);
        Lottos autoLottos = new Lottos(paidMoney);
        ResultView.printLottos(manualLottos, autoLottos);

        ResultView.printLottoResult(
                LottoService.playLotto(manualLottos.addAll(autoLottos), InputView.getWinnerNumbers()),
                paidMoney);
    }

}
