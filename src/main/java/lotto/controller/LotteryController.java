package lotto.controller;

import lotto.domain.LotteryGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LotteryController {

    public static void run() {
        LotteryGame lotteryGame = new LotteryGame();

        lotteryGame.generateLotteryTickets(InputView.getLotteryGenerateInput());
        ResultView.printLotteryTickets(lotteryGame.getLotteryTickets());

        matchLastWinningLotteryTicket(lotteryGame);
        ResultView.printFinalResult(lotteryGame.getLotteryTickets());
    }

    private static void matchLastWinningLotteryTicket(LotteryGame lotteryGame) {
        try {
            lotteryGame.matchWinningLotteryNumbers(InputView.getWinningLotteryNumberInput());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            matchLastWinningLotteryTicket(lotteryGame);
        }
    }

}
