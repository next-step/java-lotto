package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.domain.Rule.LOTTO_PRICE;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printInit();

        int price = inputView.inputPrice();
        int numbersOfLotto = price / LOTTO_PRICE.getValue();

        resultView.printNumbersOfLotto(numbersOfLotto);
        inputView.inputNextLine();

        LottoMachine lottoMachine = new LottoMachine(numbersOfLotto);
        resultView.printLottoTicketsNumbers(lottoMachine.getLottoTickets());
        resultView.printDoInputWinningNumbers();

        List<Integer> winningNumbers = inputView.getWinningNumbers();

        resultView.printResult(lottoMachine, winningNumbers, price);
    }

}
