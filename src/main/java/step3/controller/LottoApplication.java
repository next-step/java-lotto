package step3.controller;


import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int manualLottoCount = InputView.inputManualLottoCount();
        List<String> lottoNumsInputs = InputView.inputManualLottosNums(manualLottoCount);
        Lottos manualLottos = LottoMachine.butLottoManually(lottoNumsInputs);

        int remainingMoney = LottoMachine.remainingMoney(money, manualLottoCount);
        Lottos automaticLottos = LottoMachine.buyLottoAutomatically(remainingMoney);

        Lottos lottos = LottoMachine.combineLottos(manualLottos, automaticLottos);

        ResultView.printLottoList(lottos, manualLottoCount);

        String rawWinningLotto = InputView.inputWinningLotto();
        int rawBonusNum = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(LottoMachine.createLotto(rawWinningLotto), new LottoNum(rawBonusNum));

        LottoResult lottoResult = lottos.getLottoResult(winningLotto);
        ResultView.printLottoResult(lottoResult);

    }

}
