package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ResultView {

    public static final String MSG_PURCHASE_NUMBER = "개를 구매했습니다.";
    public static final String MSG_WINNING_RESULT = "당첨 통계";
    public static final String DOTTED_LINE_MARK = "---------";
    public static final int MIN_WINNING_COUNT = 3;
    public static final int MAX_WINNING_COUNT = 6;
    public static final String MSG_SAME_COUNT = "%d개 일치 (%d원) - %d개\n";
    public static final String MSG_PROFIT_RATE = "총 수익률은 %.2f 입니다.\n";

    public static void printPurchaseNumber(int n) {
        System.out.println(n + MSG_PURCHASE_NUMBER);

    }

    public static void printLottoNumbers(Lottos lottos) {
        List<String> lottonumbers = new ArrayList<>();
        for (Lotto lotto : lottos.getLottoList()) {
            lottonumbers.clear();
            lotto.getLottoNumbers().stream()
                            .forEach(number -> {
                                lottonumbers.add(Integer.toString(number.getNumber()));
                            });
            System.out.println("[" + String.join(", ", lottonumbers) + "]");
        }
        System.out.println();
    }

    public static void printWinningResult(Map<Integer, Integer> result) {
        System.out.println();
        System.out.println(MSG_WINNING_RESULT);
        System.out.println(DOTTED_LINE_MARK);
        for (int i = MIN_WINNING_COUNT; i <= MAX_WINNING_COUNT; i++) {
            int count = Objects.isNull(result.get(i)) ? 0 : result.get(i);
            System.out.printf(MSG_SAME_COUNT, i, Rank.getRank(i).getReward(), count);
        }
    }

    public static void printProfitRate(Lottos lottos) {
        System.out.printf(MSG_PROFIT_RATE, lottos.getProfitRate());
    }
}
