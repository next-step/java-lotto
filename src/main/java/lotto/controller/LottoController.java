package lotto.controller;

import lotto.domain.BonusBall;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
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

        Price price = new Price(inputView.inputNumber()); //구입금액입력
        inputView.inputNextLine();
        int numbersOfLotto = price.calculateNumberOfLotto(); //로또 갯수 계샨

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int numbersOfManualLotto = inputView.inputNumber();

        inputView.inputNextLine();

        int numbersOfAutoLotto = numbersOfLotto - numbersOfManualLotto;

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        LottoMachine lottoMachine = new LottoMachine();

        // 수동으로 구매한 로또 수만큼 로또 생성
        for (int i = 0; i < numbersOfManualLotto; i++) {
            lottoMachine.addLottoTicket(new LottoTicket(inputView.getLottoNumbers()));
        }

        // 자동으로 구매한 로또 수만큼 로또 생성
        List<LottoTicket> lottoTickets = lottoMachine.generateLottoTickets(numbersOfAutoLotto);


        System.out.println("수동으로 " + numbersOfManualLotto + "장, 자동으로 " + numbersOfAutoLotto + "개를 구매했습니다.");


        resultView.printLottoTicketsNumbers(lottoTickets);
        resultView.printDoInputWinningNumbers();

        List<Integer> winningNumbers = inputView.getLottoNumbers();
        resultView.printBonusBallNumber();

        resultView.printResult(
                lottoMachine
                , winningNumbers
                , price
                , new BonusBall(inputView.inputNumber())
        );
    }

}
