package lotto.controller;

import lotto.domain.*;
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
        ResultView resultView = new ResultView(lottoMachine);
        resultView.printLottoTicketInfos();

        // 당첨 결과 확인
        String inputNumber = inputView.inputWinnerNumber();
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoWinners lottoWinners = new LottoWinners(inputNumber, inputBonusNumber);

        LottoYield lottoYield = new LottoYield(lottoMachine.lottoTickets(), lottoWinners);

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoWinners);
        resultView.printLottoYield(lottoYield);
    }
}
