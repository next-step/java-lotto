package lotto.view;

import lotto.domain.Lotties;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.ResultRank;
import lotto.dto.PurchaseCount;

public class ResultView {
    private static final String PURCHASE_LOTTO_COUNT_MESSAGE = "수동으로 %d장 자동으로 %d개를 구매했습니다.";
    private static final String LOTTO_NUMBER_TEXT_MESSAGE = "[%s]";
    private static final String WIN_MESSAGE = "당첨통계";
    private static final String DASH = "---------";
    private static final String GAME_RANK_MESSAGE = "%d개 일치%s- %d개";
    private static final String GAME_RATE_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void purchaseLottiesInformation(PurchaseCount purchaseCount, Lotties lotties) {
        System.out.printf((PURCHASE_LOTTO_COUNT_MESSAGE) + "%n", purchaseCount.getManualCount(), purchaseCount.getAutoCount(), lotties.purchaseLottiesCount());
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
        printRank(Rank.SECOND, result);
        printRank(Rank.FIRST, result);
        System.out.println(String.format(GAME_RATE_MESSAGE, result.getRate(purchaseMoney)));
    }

    private void printRank(Rank rank, ResultRank result) {
        System.out.println(String.format(GAME_RANK_MESSAGE, rank.getMatchCount(), this.prizeMoneyText(rank), result.getPrizeCount(rank)));
    }

    private String prizeMoneyText(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        if (rank == Rank.SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append("(");
        stringBuilder.append(rank.getPrizeMoney());
        stringBuilder.append(")원");

        return stringBuilder.toString();
    }
}
