package lotto.controller;

import lotto.controller.response.LottosDto;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void lottoGameStart() {
        int paidMoney = InputView.getMoney();
        int manualLottoCount = InputView.getManualLottoCount();

        Lottos lottos = getLottos(paidMoney, manualLottoCount);

        ResultView.printLottoResult(
                LottoService.playLotto(lottos, InputView.getWinnerNumbers()),
                paidMoney);
    }

    private static Lottos getLottos(int paidMoney, int manualLottoCount) {
        Lottos manualLottos = InputView.getLottos(manualLottoCount);
        Lottos autoLottos = Lottos.getAutoLottos(paidMoney, manualLottoCount);

        ResultView.printLottos(LottosDto.getInstance(manualLottos, autoLottos));

        return manualLottos.addAll(autoLottos);
    }

}
