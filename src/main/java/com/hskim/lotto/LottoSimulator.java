package com.hskim.lotto;

import com.hskim.lotto.model.*;
import com.hskim.lotto.ui.LottoInputView;
import com.hskim.lotto.ui.LottoResultView;

import java.util.List;


public class LottoSimulator {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoResultView lottoResultView = new LottoResultView();
        LottoTickets lottoTickets;
        LottoGame lottoGame;
        LottoGameResult lottoGameResult;

        lottoInputView.printPurchasePhrase();
        int purchasePrice = lottoInputView.getPurchasePriceFromInput();
        lottoTickets = new LottoTickets(new PurchasePrice(purchasePrice), new RandomNumberMaker());

        lottoResultView.printPurchaseNum(lottoTickets.getTicketsSize());
        lottoResultView.printString(lottoTickets.makeLottoTicketsString());

        lottoInputView.printWinPhrase();
        List<Integer> winningTicketNumbers = lottoInputView.getWinningTicketNumbers();

        lottoGame = new LottoGame(lottoTickets, new LottoWinningTicket(winningTicketNumbers));
        lottoGameResult = lottoGame.drawLotteryTicket();

        lottoResultView.printStatisticResult(lottoGameResult.getStatisticMap());
        lottoResultView.printEarningRate(lottoGameResult.getEarningRate(), lottoGameResult.isProfit());
    }
}
