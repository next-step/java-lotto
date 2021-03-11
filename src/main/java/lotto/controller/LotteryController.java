package lotto.controller;

import lotto.domain.LotteryGame;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LotteryController {

    public static void run() {
        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.generateLotteryTickets(InputView.getLotteryGenerateInput());
        ResultView.printLotteryTickets(lotteryGame.getLotteryTickets());

        LotteryStatisticMatchResult lotteryStatisticMatchResult = matchLastWinningLotteryTicket(lotteryGame);
        ResultView.printFinalResult(lotteryStatisticMatchResult);
    }

//    private static List<LotteryTicketDto> generateLotteryTickets(LotteryGame lotteryGame) {
//        try {
//            return lotteryGame.generateLotteryTickets(InputView.getLotteryGenerateInput());
//        } catch (IllegalArgumentException exception) {
//            InputView.printWrongInputMessage();
//            return generateLotteryTickets(lotteryGame);
//        }
//    }

    private static LotteryStatisticMatchResult matchLastWinningLotteryTicket(LotteryGame lotteryGame) {
        try {
            return lotteryGame.matchWinningLotteryNumbers(InputView.getWinningLotteryNumberInput());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            return matchLastWinningLotteryTicket(lotteryGame);
        }
    }
    }
}
