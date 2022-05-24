package lotto.view;

import lotto.domain.*;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    public static final String RESULT_LOSS = "손해";
    private static final String RESULT_BREAK_EVEN = "본전";
    private static final String RESULT_PROFIT = "이득";
    private static final String ENTER = "\n";
    private static final int PROFIT_STANDARD = 1;
    private static final int ZERO = 0;

    private ResultView() {
    }

    public static void resultLotto(int manualSize, int numberOfLotto, Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        int remainNumberOfLotto = numberOfLotto - manualSize;
        stringBuilder.append(String.format("%s수동으로 %d장, 자동으로 %d개를 구매하였습니다.%s", ENTER, manualSize, remainNumberOfLotto, ENTER));
        for (Lotto lotto : lottos.getLottos()) {
            resultLottoNumber(lotto, stringBuilder);
        }
        System.out.print(stringBuilder);
    }

    private static void resultLottoNumber(Lotto lotto, StringBuilder stringBuilder) {
        String lottoNumbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        stringBuilder.append(String.format("[%s]%s", lottoNumbers, ENTER));
    }

    public static void resultWinners(Winners winners) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Rank, Integer> winnerResult = winners.getWinners();
        stringBuilder.append(String.format("%s당첨 통계%s---------%s", ENTER, ENTER, ENTER));
        winnerResult.forEach(
                ((rank, count) -> stringBuilder.append(resultWinner(rank, count))));
        System.out.println(stringBuilder);
    }

    private static String resultWinner(Rank rank, int count) {
        int key = rank.getNumberOfSame();
        int winnings = rank.getWinnings();
        if (key == ZERO) {
            return "";
        }
        if (isBonusWinnings(rank)) {
            return String.format("%d개 일치, 보너스볼 일치(%d원)- %d개%s", key, winnings, count, ENTER);

        }
        return String.format("%d개 일치(%d원)- %d개%s", key, winnings, count, ENTER);
    }

    private static boolean isBonusWinnings(Rank winningsType) {
        return winningsType.equals(Rank.이등);
    }

    public static void resultProfit(Winners winners, int money) {
        double revenue = winners.revenue(money);
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)", revenue, resultProfit(revenue)));
    }

    private static String resultProfit(double revenue) {
        if (revenue > PROFIT_STANDARD) {
            return RESULT_PROFIT;
        }
        if (revenue < PROFIT_STANDARD) {
            return RESULT_LOSS;
        }
        return RESULT_BREAK_EVEN;
    }
}
