package com.hskim.lotto;

import com.hskim.lotto.model.*;
import com.hskim.lotto.ui.LottoInputView;
import com.hskim.lotto.ui.LottoResultView;


public class LottoSimulator {

    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoResultView lottoResultView = new LottoResultView();
        LottoGame lottoGame;
        LottoTickets lottoTickets;
        PurchasePrice purchasePrice;

        lottoInputView.printPurchasePhrase();
        purchasePrice = lottoInputView.getPurchasePriceFromInput();
        lottoTickets = new LottoTickets(purchasePrice, new RandomNumberMaker());

        lottoResultView.printPurchaseNum(lottoTickets.makeTicketsSizeString());
        lottoResultView.printString(lottoTickets.makeLottoTicketsString());

        lottoInputView.printWinPhrase();
        LottoWinningTicket winningTicket = lottoInputView.getWinningTicket();

        lottoGame = new LottoGame(lottoTickets, winningTicket);
        lottoGame.drawLots();
        lottoResultView.printString(lottoGame.getWinnerStatisticString());
    }
}
