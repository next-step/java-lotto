package lotto.controller;

import lotto.domain.LotteryGame;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryController {

    public static void run() {
        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.generateLotteryTickets(InputView.getLotteryGenerateInput());
        ResultView.printLotteryTickets(lotteryGame.getLotteryTickets());

        LotteryStatisticMatchResult lotteryStatisticMatchResult = matchLastWinningLotteryTicket(lotteryGame);
        ResultView.printFinalResult(lotteryStatisticMatchResult);
    }

    private static LotteryStatisticMatchResult matchLastWinningLotteryTicket(LotteryGame lotteryGame) {
        try {
            return lotteryGame.matchWinningLotteryNumbers(InputView.getWinningLotteryNumberInput());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            return matchLastWinningLotteryTicket(lotteryGame);
        }
    }

}
