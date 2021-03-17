package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public void run() {
        // 구매 금액 입력
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();

        // 로또 발급
        LottoMachine lottoMachine = new LottoMachine(buyAmount);

        // 로또 번호 확인
        ResultView resultView = new ResultView();
        resultView.printLottoTicketInfos(lottoMachine);

        // 당첨 결과 확인

    }
}
