package lotto.controller;

import lotto.domain.LotteryGame;
import lotto.dto.LotteryGameRequest;
import lotto.dto.LotteryStatisticMatchResult;
import lotto.dto.LotteryTicketDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LotteryController {

    public static void run() {
        LotteryGame lotteryGame = new LotteryGame();
        lotteryGame.generateLotteryTickets(InputView.getUserInput());
        List<LotteryTicketDto> lotteryTickets = lotteryGame.getLotteryTickets();
        ResultView.printLotteryTickets(lotteryTickets);

        LotteryStatisticMatchResult lotteryStatisticMatchResult = matchLastWinningLotteryTicket(lotteryGame);
        ResultView.printFinalResult(lotteryStatisticMatchResult);
    }

    private static List<LotteryTicketDto> generateLotteryTickets(LotteryGame lotteryGame) {
        try {
            return lotteryGame.generateLotteryTickets(InputView.getUserInput());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            return generateLotteryTickets(lotteryGame);
        }
    }

    private static LotteryStatisticMatchResult matchLastWinningLotteryTicket(LotteryGame lotteryGame) {
        try {
            return lotteryGame.matchWinningLotteryNumbers(InputView.getLastWinningLotteryNumbers());
        } catch (IllegalArgumentException exception) {
            InputView.printWrongInputMessage();
            return matchLastWinningLotteryTicket(lotteryGame);
        }
    }
    }
}
