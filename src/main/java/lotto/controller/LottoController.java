package lotto.controller;

import lotto.domain.BonusBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Price;
import lotto.domain.WinningNumbers;
import lotto.domain.number_generator.ManualNumberGenerator;
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

        Price price = new Price(inputView.inputNumber()); //구입금액입력
        inputView.inputNextLine();

        int numbersOfLotto = price.calculateNumberOfLotto(); //로또 갯수 계샨

        resultView.printInputNumbersOfManualLotto();
        int numbersOfManualLotto = inputView.inputNumber();
        inputView.inputNextLine();

        int numbersOfAutoLotto = numbersOfLotto - numbersOfManualLotto;

        resultView.printInputManualLottoNumbers();
        LottoMachine lottoMachine = new LottoMachine();
        // 수동으로 구매한 로또 수만큼 로또 생성
        generateManualLotto(numbersOfManualLotto, lottoMachine);
        // 자동으로 구매한 로또 수만큼 로또 생성
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets(numbersOfAutoLotto);

        resultView.printEachNumbersOfLotto(numbersOfManualLotto, numbersOfAutoLotto);
        resultView.printLottoTickets(lottoTickets);
        resultView.printDoInputWinningNumbers();

        WinningNumbers winningNumbers = WinningNumbers.of(new ManualNumberGenerator(inputView).generate());

        resultView.printBonusBallNumber();

        resultView.printResult(
                lottoMachine
                , winningNumbers
                , price
                , new BonusBall(inputView.inputNumber())
        );
    }

    private void generateManualLotto(int numbersOfManualLotto, LottoMachine lottoMachine) {
        for (int i = 0; i < numbersOfManualLotto; i++) {
            lottoMachine.addLottoTicket(new LottoTicket(new ManualNumberGenerator(inputView).generate()));
        }
    }

}
