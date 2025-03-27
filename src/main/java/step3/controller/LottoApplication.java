package step3.controller;


import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoList lottoList = LottoMachine.buyLotto(money);
        ResultView.printLottoList(lottoList);

        String rawWinningLotto = InputView.inputWinningLotto();
        int rawBonusNum = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(LottoMachine.createLotto(rawWinningLotto), new LottoNum(rawBonusNum));

        LottoResult lottoResult = lottoList.getLottoResult(winningLotto);
        ResultView.printLottoResult(lottoResult);

    }

}
