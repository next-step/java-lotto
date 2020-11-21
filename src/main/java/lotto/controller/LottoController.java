package lotto.controller;

import lotto.model.*;
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
    private Lotto winningLotto;

    public void run() {

        String inputAmount = inputView.printInputMessageNGetAmount();
        amount = new Amount(inputAmount);

        buyLottoes();

        String inputWinnerNumber = inputView.printInputMessageNGetWinnerNumbers();
        winningLotto = getWinnerNumbers(inputWinnerNumber);

        lottery();
    }

    private void buyLottoes() {
        lottoes = new Lottoes(amount.getPrePurchaseAmount(0, Lotto.PRICE));
        resultView.printBuyMessage(lottoes.getLottoCount());
        resultView.printLottoes(lottoes.getLottoes());
    }

    private void lottery() {
        int lottoCount = lottoes.getLottoCount();
        int prePurchaseAmount = amount.getPrePurchaseAmount(lottoCount, Lotto.PRICE);

        List<Set<Integer>> lottoesNumbers = lottoes.getLottoes();
        Map<Hit, Integer> winnerNumbers = ((WinningLotto) winningLotto).getResult(lottoesNumbers);
        double earningRate = ((WinningLotto) winningLotto).getEarningRate(prePurchaseAmount, lottoesNumbers);

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

        return new WinningLotto(new ManualDrawing(winnerNumbers));
    }

}
