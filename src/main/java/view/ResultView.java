package view;

import domain.Lotto;
import domain.Prize;
import domain.WinningStatus;

import java.util.List;

public class ResultView {

    public static void purchasedLottoGames(List<Lotto> lottoGames) {
        System.out.println(lottoGames.size() + "개를 구매했습니다.");
        lottoGames.forEach(System.out::println);
    }

    public static void lottoResult(WinningStatus status) {
        System.out.println("당첨통계\n--------");

        prizeResult(Prize.FOURTH_PRIZE, status.getPrizeCount(Prize.FOURTH_PRIZE));
        prizeResult(Prize.THIRD_PRIZE, status.getPrizeCount(Prize.THIRD_PRIZE));
        prizeResult(Prize.SECOND_PRIZE, status.getPrizeCount(Prize.SECOND_PRIZE));
        prizeResult(Prize.FIRST_PRIZE, status.getPrizeCount(Prize.FIRST_PRIZE));

        profitRate(status.getProfit());
    }

    private static void prizeResult(Prize prize, int matched) {
        System.out.println(prize.getForWin() + "개 일치 (" + prize.getReward() + ") - " + matched);
    }

    private static void profitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
