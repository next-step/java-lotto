package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.util.List;

public class OutputView {
    private static final String PRINT_GAME_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String PRINT_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String PRINT_RESULT_CONSIDER_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final String PRINT_RESULT_TITLE = "당첨 통계\n---------";
    private static final String PRINT_YIELD_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String PRINT_YIELD_UNDER_ZERO_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printGameCount(int lottoSize) {
        System.out.println(String.format(PRINT_GAME_COUNT_MESSAGE, lottoSize));
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResult result) {
        printResultTitle();

        for (LottoRank lottoRank : LottoRank.values()) {
            printRank(result, lottoRank);
        }

        printYield(result.yield());
    }

    private static void printRank(LottoResult result, LottoRank lottoRank) {
        int count = result.rankCount(lottoRank);
        int rankCount = lottoRank.getCount();
        int rankMoney = lottoRank.getMoney();

        if (lottoRank.isConsiderBonus()) {
            System.out.println(String.format(PRINT_RESULT_CONSIDER_BONUS_MESSAGE, rankCount, rankMoney, count));
            return;
        }
        System.out.println(String.format(PRINT_RESULT_MESSAGE, rankCount, rankMoney, count));
    }

    private static void printResultTitle() {
        System.out.println();
        System.out.println(PRINT_RESULT_TITLE);
    }

    private static void printYield(double yield) {
        System.out.print(String.format(PRINT_YIELD_MESSAGE, yield));

        if (yield < 1) {
            System.out.print(PRINT_YIELD_UNDER_ZERO_MESSAGE);
        }

        System.out.println();
    }
}
