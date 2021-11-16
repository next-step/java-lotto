package step2.view;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.Number;

import java.util.stream.Collectors;

public class ResultView {
    private static final String LEFT_SQUARE_BRACKET = "[";
    private static final String RIGHT_SQUARE_BRACKET = "]";
    private static final String PURCHASE_LOTTO_RESULT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DASH_LINE = "---------";

    public static void showLottoGenerateCount(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + PURCHASE_LOTTO_RESULT_MESSAGE);
    }

    public static void showAllLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String numbers = lotto.getLottoNumbers().stream()
                    .map(Number::getStringNumber)
                    .collect(Collectors.joining(", "));
            System.out.println(LEFT_SQUARE_BRACKET + numbers + RIGHT_SQUARE_BRACKET);
        }
    }

    public static void showWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DASH_LINE);
        System.out.println("");
    }
}
