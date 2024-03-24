package lotto.controller;

import lotto.domain.BonusBall;
import lotto.domain.LottoMachine;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        resultView.printInit();

        Price price = new Price(inputView.inputPrice());
        int numbersOfLotto = price.calculateNumberOfLotto();

        resultView.printNumbersOfLotto(numbersOfLotto);
        inputView.inputNextLine();

        LottoMachine lottoMachine = new LottoMachine(numbersOfLotto);
        //lottoMachine.generateLottoTickets();
        resultView.printLottoTicketsNumbers(lottoMachine.getLottoTickets());
        resultView.printDoInputWinningNumbers();

        List<Integer> winningNumbers = inputView.getWinningNumbers();
        resultView.printBonusBallNumber();

        resultView.printResult(
                lottoMachine
                , winningNumbers
                , price
                , new BonusBall(inputView.getBonusBallNumber())
        );
    }

}
