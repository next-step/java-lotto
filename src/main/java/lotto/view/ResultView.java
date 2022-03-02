package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Rank;

public class ResultView {

    private static final String DELIMETER = ", ";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String DIVISION = "================";
    private static final String BONUS_BALL_MATCH = ", 보너스 볼 일치";
    private static final String TOTAL_INCOME_PRE = "총 수익률은 ";
    private static final String TOTAL_INCOME_POST = "입니다.";

    private ResultView() {

    }

    public static void printCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public static void printLottos(LottoTicket lottos) {
        lottos.getLottoTicket()
            .forEach(lotto -> System.out.println("[" + lottoNumberToString(lotto) + "]"));
    }

    private static String lottoNumberToString(Lotto lotto) {
        return lotto.getLotto().stream()
            .map(LottoNumber::getLottoNumber)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(DELIMETER));
    }

    public static void printWin(LottoResult lottoResult, Money money) {
        System.out.println(LOTTO_RESULT);
        System.out.println(DIVISION);

        for (Rank rank : Rank.values()) {
            System.out.print(printResult(rank, lottoResult));
        }

        printProfit(lottoResult, money);
    }

    private static String printResult(Rank rank, LottoResult lottoResult) {
        String bonusBall = "";

        if (rank.isNothing()) {
            return String.format("꽝 입니다 (%d원)- %d개\n", rank.getMoney(),
                lottoResult.findStatistics(rank));
        }

        if (rank.isSecond()) {
            bonusBall = BONUS_BALL_MATCH;
        }

        return String.format("%d개 일치 %s (%d원)- %d개\n", rank.getMatch(), bonusBall,
            rank.getMoney(), lottoResult.findStatistics(rank));
    }

    private static void printProfit(LottoResult lottoResult, Money money) {
        String result = String.format("%s %.2f%s\n",
            TOTAL_INCOME_PRE,
            (float) lottoResult.getWinProfit() / money.getMoney(),
            TOTAL_INCOME_POST
        );

        System.out.printf(result);
    }
}
