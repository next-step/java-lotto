package lotto.controller;

import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {

    public static void lottoGameStart() {
        int paidMoney = InputView.getMoney();

        Lottos lottos = new Lottos(paidMoney);
        ResultView.printLottos(lottos);


        ResultView.printLottoResult(
                LottoService.playLotto(lottos, InputView.getWinnerNumber()),
                paidMoney);
    }



}
