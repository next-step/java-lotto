package com.hskim.lotto;

import com.hskim.lotto.model.*;
import com.hskim.lotto.ui.LottoInputView;
import com.hskim.lotto.ui.LottoResultView;

import java.util.List;


public class LottoSimulator {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoResultView lottoResultView = new LottoResultView();

        lottoInputView.printPurchasePhrase();
        int purchasePrice = lottoInputView.getPurchasePriceFromInput();
        LottoTickets lottoTicketsAuto = LottoMachine.automaticIssuance(
                new PurchasePrice(purchasePrice), new RandomLottoNumberMaker()
        );

        lottoInputView.printManualTicketingNumPhrase();
        int manualTicketingNum = lottoInputView.getManualTicketingNum();

        lottoInputView.printManualTicketingPhrase();
        LottoTickets lottoTicketsManual = LottoMachine.manualIssuance(
                lottoInputView.getManualLottoNumbersList(manualTicketingNum)
        );

        lottoResultView.printPurchaseNum(lottoTicketsManual.getTicketsSize(), lottoTicketsAuto.getTicketsSize());
        lottoResultView.printString(lottoTicketsManual.makeLottoTicketsString());
        lottoResultView.printString(lottoTicketsAuto.makeLottoTicketsString());

        lottoInputView.printWinPhrase();
        List<Integer> winningTicketNumbers = lottoInputView.getTicketNumbers();
        lottoInputView.printBonusBallPhrase();
        int bonusNumber = lottoInputView.getBonusNumber();

        LottoTickets mergedTickets = lottoTicketsAuto.mergeTickets(lottoTicketsManual);
        LottoGame lottoGame = new LottoGame(mergedTickets, new LottoWinningTicket(winningTicketNumbers, bonusNumber));
        LottoGameResult lottoGameResult = lottoGame.drawLotteryTicket();

        lottoResultView.printStatisticResult(lottoGameResult.getStatisticMap());
        lottoResultView.printEarningRate(lottoGameResult.getEarningRate(), lottoGameResult.isProfit());
    }
}
