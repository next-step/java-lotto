package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        // 구매 금액, 수동 수 입력
        InputView inputView = new InputView();
        int buyAmount = inputView.inputBuyAmount();
        int manualQuantity = inputView.inputManualQuantity();

        LottoQuantity lottoQuantity = new LottoQuantity(buyAmount, manualQuantity);
        List<List<Integer>> inputManual = inputView.inputManualNumbers(manualQuantity);

        // 로또 발급
        LottoTickets lottoTickets = LottoFactory.createLottoTickets(lottoQuantity, inputManual);

        // 로또 번호 확인
        ResultView resultView = new ResultView(lottoTickets);
        resultView.printLottoQuantity(lottoQuantity);
        resultView.printLottoTicketInfos();

        // 당첨 결과 확인
        List<Integer> inputNumber = inputView.inputWinnerNumber();
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoWinners lottoWinners = LottoFactory.createWinners(inputNumber, inputBonusNumber);

        // 당첨 내역 출력
        resultView.printLottoRanksInfos(lottoWinners);
        resultView.printLottoYield(lottoTickets, lottoWinners);
    }
}
