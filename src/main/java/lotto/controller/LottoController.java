package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printInit();

        int price = inputView.inputPrice();
        int numbersOfLotto = price / LOTTO_PRICE;

        resultView.printNumbersOfLotto(numbersOfLotto);
        inputView.inputNextLine();

        LottoMachine lottoMachine = new LottoMachine(numbersOfLotto);
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets();
        resultView.printLottoTicketsNumbers(lottoTickets);
        resultView.printDoInputWinningNumbers();

        List<Integer> winningNumbers = inputView.getWinningNumbers();

        resultView.printResult(lottoMachine, winningNumbers, price);
    }

}
