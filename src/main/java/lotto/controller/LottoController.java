package lotto.controller;

import lotto.model.Amount;
import lotto.model.Hit;
import lotto.model.Lotto;
import lotto.model.Lottoes;
import lotto.strategy.ManualDrawing;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LottoController {
    private final Pattern WINNER_NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private Amount amount;
    private Lottoes lottoes;
    private Lotto winnerLotto;

    public void run() {

        String inputAmont = inputView.printInputMessageNGetAmount();
        amount = new Amount(inputAmont);

        buyLottoes();

        String inputWinnerNumber = inputView.printInputMessageNGetWinnerNumbers();
        winnerLotto = getWinnerNumbers(inputWinnerNumber);

        lottery();
    }

    private void buyLottoes() {
        lottoes = new Lottoes(amount.pay(0));
        resultView.printBuyMessage(lottoes.getLottoCount());
        resultView.printLottoes(lottoes.getLottoes());
    }

    private void lottery() {
        Map<Hit, Integer> winnerNumbers = lottoes.getResult(winnerLotto.getNumbers());
        double earningRate = lottoes.getEarningRate(winnerLotto.getNumbers());
        resultView.printResult(winnerNumbers);
        resultView.printEarningRate(earningRate);
    }

    private Lotto getWinnerNumbers(String stringNumbers) {
        Matcher matcher = WINNER_NUMBER_PATTERN.matcher(stringNumbers);
        Set<Integer> winnerNumbers = new HashSet<>();

        while (matcher.find()) {
            int winnerNumber = Integer.parseInt(matcher.group());
            winnerNumbers.add(winnerNumber);
        }

        return new Lotto(new ManualDrawing(winnerNumbers));
    }

}
