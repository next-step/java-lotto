package step2.controller;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {
    private int numberOfLottoTickets;
    private List<LottoTicket> lottoTickets;

    public void run(){
        buyLottoTicket();
        result();
    }

    private void buyLottoTicket(){
        InputView.inputPayments();
        numberOfLottoTickets = InputView.getNumberOfLottoTickets();

        LottoTickets lottoTickets = new LottoTickets(numberOfLottoTickets);
        this.lottoTickets = lottoTickets.getLottoTickets();
    }

    private void result(){
        ResultView.printMyLottoTickets(lottoTickets, numberOfLottoTickets);
        ResultView.printLottoPrizeNumber();
    }

}
