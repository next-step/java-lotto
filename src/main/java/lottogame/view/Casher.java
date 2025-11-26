package lottogame.view;

import java.util.Arrays;
import java.util.List;

public class Casher {
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

    public static void informWinResult(String winResultMessage) {
        OutputView.printWinResultMsg(winResultMessage);
    }
}
