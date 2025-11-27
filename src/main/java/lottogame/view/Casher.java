package lottogame.view;

import static lottogame.model.winner.WinStandard.FIRST;
import static lottogame.model.winner.WinStandard.FOURTH;
import static lottogame.model.winner.WinStandard.SECOND;
import static lottogame.model.winner.WinStandard.THIRD;

import java.util.Arrays;
import java.util.List;
import lottogame.model.winner.WinnerResult;

public class Casher {

    private static final String FIRST_WIN_MESSAGE = "6개 일치 (2000000000원)- ";
    private static final String SECOND_WIN_MESSAGE = "5개 일치, 보너스볼 일치 (30000000원)- ";
    private static final String THIRD_WIN_MESSAGE = "5개 일치 (1500000원)- ";
    private static final String FOURTH_WIN_MESSAGE = "4개 일치 (50000원)- ";
    private static final String FIFTH_WIN_MESSAGE = "3개 일치 (5000원)- ";

    public static int askBuyPrice() {
        OutputView.printQuestionByBuyPrice();
        return InputView.inputInt();
    }

    public static void informBuyCount(int buyCount) {
        OutputView.printBuyLottoCount(buyCount);
    }

    public static List<Integer> askBeforeWinNums() {
        OutputView.printQuestionBeforeWinNums();
        String rawValue = InputView.inputString();

        return Arrays.stream(rawValue.split(", "))
                .map(Integer::parseInt)
                .toList();
    }

    public static int askBonusNum() {
        OutputView.printQuestionBonusLottoNum();
        return InputView.inputInt();
    }

    public static void informPublishedLottos(List<String> perLottoNums) {
        for (String perLottoNum : perLottoNums) {
            OutputView.printPerLottoNums(perLottoNum);
        }
    }

    public static void informWinResult(WinnerResult winnerResult, int lottoPurchasePrice) {
        String msg = FIRST_WIN_MESSAGE + winnerResult.findWinCount(FIRST)
                + SECOND_WIN_MESSAGE + winnerResult.findWinCount(SECOND)
                + THIRD_WIN_MESSAGE + winnerResult.findWinCount(THIRD)
                + FOURTH_WIN_MESSAGE + winnerResult.findWinCount(FOURTH)
                + FIFTH_WIN_MESSAGE + winnerResult.findWinCount(FIRST)
                + FIFTH_WIN_MESSAGE + winnerResult.findWinCount(FIRST)
                + "총 수익률은 " + winnerResult.calculateRateOfReturn(lottoPurchasePrice) + "입니다.";

        OutputView.printWinResultMsg(msg);
    }
}
