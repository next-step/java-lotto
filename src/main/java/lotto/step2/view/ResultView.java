package lotto.step2.view;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.Lottos;

import java.util.stream.Collectors;

public class ResultView {

    private static final String PURCHASE_MSG = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String NEWLINE_CHARACTER = "\n";
    private static final String FRONT_BRACKETS = "[";
    private static final String END_BRACKETS = "]";

    private ResultView() {
    }

    public static void printPurchaseAmount(int amount) {
        System.out.println(amount + PURCHASE_MSG);
    }

    public static void printLottos(Lottos lottos) {
        String lottoList = lottos.stream()
                .map(ResultView::lottoToString)
                .collect(Collectors.joining());

        System.out.println(lottoList);
    }

    private static String lottoToString(Lotto lotto) {
        return FRONT_BRACKETS + lotto.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER))
                + END_BRACKETS + NEWLINE_CHARACTER;
    }

    public static void printWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MSG);
    }
}
