package view;

import domain.LottoGames;
import domain.Prize;
import domain.WinningStatus;

public class ResultView {

    public static void purchasedLottoGames(LottoGames lottoGames) {
        String puchasedCount = "수동으로 " +
            lottoGames.getManualGameCount() +
            "장, 자동으로 " +
            lottoGames.getAutoGameCount() +
            "개를 구매했습니다.";
        System.out.println(puchasedCount);
        lottoGames.getGames().forEach(System.out::println);
    }

    public static void lottoResult(WinningStatus status) {
        System.out.println("당첨통계\n--------");

        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) continue;
            prizeResult(prize, status.getPrizeCount(prize));
        }

        profitRate(status.getProfit());
    }

    private static void prizeResult(Prize prize, int matched) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(prize.getToWin()).append("개 일치");
        if (prize.getRequireBonus()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (").append(prize.getReward()).append(") - ");
        stringBuilder.append(matched).append("개");

        System.out.println(stringBuilder.toString());
    }

    private static void profitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
