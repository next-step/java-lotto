package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.object.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;

public class LottoGameMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        final String money = inputView.getMoney();

        LottoGame game = new LottoGame(money);
        resultView.printLottoGame(game);

        final String luckyNumbers = inputView.getLuckyNumbers();
        final int[] luckyNumber = splitLuckyNumbers(luckyNumbers);
        final Lotto LUCKY_NUMBERS = new Lotto(luckyNumber);

        resultView.printLottoResult(game, LUCKY_NUMBERS);
    }

    private static int[] splitLuckyNumbers(final String luckyNumbers) {
        final String TOKEN_FOR_LUCKY_NUMBERS = ",";
        final String[] split = luckyNumbers.trim().split(TOKEN_FOR_LUCKY_NUMBERS);
        return Arrays.stream(split)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
