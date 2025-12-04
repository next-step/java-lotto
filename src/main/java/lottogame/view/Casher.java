package lottogame.view;

import static java.lang.Math.floor;
import static lottogame.model.lotto.LottoMachine.LOTTO_NUM_COUNT;
import static lottogame.model.winner.WinStandard.FIFTH;
import static lottogame.model.winner.WinStandard.FIRST;
import static lottogame.model.winner.WinStandard.FOURTH;
import static lottogame.model.winner.WinStandard.SECOND;
import static lottogame.model.winner.WinStandard.THIRD;
import static lottogame.view.InputView.inputString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lottogame.model.price.LottoPurchasePrice;
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

    public static void informBuyCount(int autoCount, int manualCount) {
        OutputView.printBuyLottoCount(autoCount, manualCount);
    }

    public static List<Set<Integer>> askManualLottos() {
        return askManualLottoNums(askManualLottoCount());
    }

    private static int askManualLottoCount() {
        OutputView.printQuestionManualLottoCount();

        return InputView.inputInt();
    }

    private static List<Set<Integer>> askManualLottoNums(int manualCount) {
        List<Set<Integer>> rawManualNums = new ArrayList<>();

        OutputView.printQuestionManualLottoNums();
        for (int i = 0; i < manualCount; i++) {
            String rawValue = inputString();
            Set<Integer> e = splitAndParseLottoNums(rawValue);
            rawManualNums.add(e);
        }

        return rawManualNums;
    }

    public static Set<Integer> askLottoNums() {
        OutputView.printQuestionBeforeWinNums();
        String rawValue = inputString();

        return splitAndParseLottoNums(rawValue);
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

    public static void informWinResult(WinnerResult winnerResult, double rateOfReturn) {
        String msg = FIRST_WIN_MESSAGE + winnerResult.findWinCount(FIRST) + "개\n"
                + SECOND_WIN_MESSAGE + winnerResult.findWinCount(SECOND) + "개\n"
                + THIRD_WIN_MESSAGE + winnerResult.findWinCount(THIRD) + "개\n"
                + FOURTH_WIN_MESSAGE + winnerResult.findWinCount(FOURTH) + "개\n"
                + FIFTH_WIN_MESSAGE + winnerResult.findWinCount(FIFTH) + "개\n"
                + "총 수익률은 " + rateOfReturn + "입니다.";

        OutputView.printWinResultMsg(msg);
    }

    // 입렵 받는 방식에 문제가 있는듯.. 다시 볼것.
    private static Set<Integer> splitAndParseLottoNums(String rawValue) {
        Set<Integer> inputLottoNums = Arrays.stream(rawValue.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        if (inputLottoNums.isEmpty() || inputLottoNums.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또번호 갯수를 정확히 입력해 주세요. 6개가 아니거나 중복은 허용되지 않습니다");
        }

        return inputLottoNums;
    }
}
