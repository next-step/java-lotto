package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.ResultRank;

public class ResultView {
    private static String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static String LOTTO_NUMBER_TEXT_MESSAGE = "[%s]";
    private static String WIN_MESSAGE = "당첨통계";
    private static String DASH = "---------";
    private static String GAME_RANK_MESSAGE = "%d개 일치(%d원)- %d개";
    private static String GAME_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void purchaseLottiesInformation(Lotties lotties) {
        System.out.printf((PURCHASE_LOTTO_COUNT_MESSAGE) + "%n", lotties.purchaseLottiesCount());
        lotties.getLotties().stream()
                .map(Lotto::getNumbers)
                .forEach(n -> System.out.printf((LOTTO_NUMBER_TEXT_MESSAGE) + "%n", n));
        System.out.println();
    }

    public void printGameResult(ResultRank result, int purchaseMoney) {
        System.out.println(WIN_MESSAGE);
        System.out.println(DASH);
        printRank(Rank.FIFTH, result);
        printRank(Rank.FOURTH, result);
        printRank(Rank.THIRD, result);
        printRank(Rank.FIRST, result);
        System.out.println(String.format(GAME_RATE_MESSAGE, result.getRate(purchaseMoney)));
    }

    private void printRank(Rank rank, ResultRank result) {
        System.out.println(String.format(GAME_RANK_MESSAGE, rank.getMatchCount(), rank.getPrizeMoney(), result.getPrizeCount(rank)));
    }
}
