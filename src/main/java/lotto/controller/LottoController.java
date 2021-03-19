package lotto.controller;

import lotto.domain.*;
import lotto.strategy.Manual;
import lotto.strategy.Numbers;
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
        String winnerNumbers = inputView.inputWinnerNumber();
        Numbers winnerNumber = new Manual(winnerNumbers);
        LottoYield lottoYield = new LottoYield(lottoMachine.lottoTickets(), winnerNumber);

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoMachine.lottoTickets(), winnerNumber);
        resultView.printLottoYield(lottoYield);
    }
}
