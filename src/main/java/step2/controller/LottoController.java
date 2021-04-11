package step2.controller;

import step2.domain.LottoTickets;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoController {
    private LottoTickets lottoTickets;
    private List<Integer> winningNumbers;

    public LottoController(){
        buyLottoTicket();
        inputWinningNumbers();
    }

    private void buyLottoTicket(){
        InputView.inputPayments();
        int numberOfLottoTickets = InputView.getNumberOfLottoTickets();
        lottoTickets = new LottoTickets(numberOfLottoTickets);
        ResultView.printMyLottoTickets(lottoTickets);
    }

    private void inputWinningNumbers(){
        InputView.inputWinningNumberS();
        winningNumbers = InputView.getWinningNumbers();
    }

}
