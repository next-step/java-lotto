package lotto.controller;

import lotto.model.Amount;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.strategy.ManualDrawing;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoController {
    private final Pattern WINNER_NUMBER_PATTERN = Pattern.compile("\\d+");
    private Scanner scanner = new Scanner(System.in);

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private Amount amount;
    private Lottoes lottoes;
    private Lotto winnerLotto;

    public void run() {
        inputAmount();
        buyLottoes();
        inputWinnerNumbers();
    }

    private void inputAmount() {
        inputView.printInputAmountMessage();
        amount = new Amount(scanner.nextLine());
    }


    private void buyLottoes() {
        lottoes = new Lottoes(amount.pay(0));
        resultView.printBuyMessage(lottoes.getLottoCount());
        resultView.printLottoes(lottoes.getLottoes());
    }


    private void inputWinnerNumbers() {
        inputView.printInputWinnerNumbersMessage();
        winnerLotto = getWinnerNumbers(scanner.nextLine());
    }


    private Lotto getWinnerNumbers(String stringNumbers) {
        Matcher matcher = WINNER_NUMBER_PATTERN.matcher(stringNumbers);
        List<Integer> winnerNumbers = new ArrayList<>();

        while (matcher.find()) {
            int winnerNumber = Integer.parseInt(matcher.group());
            winnerNumbers.add(winnerNumber);
        }

        return new Lotto(new ManualDrawing(winnerNumbers));
    }

}
