package lotto.view;

import lotto.domain.LottoPaper;
import lotto.domain.Rank;
import lotto.domain.Statistics;

import java.util.List;

public class ResultView {

    public static final String FIRST_MSG = "6개 일치 (" + Rank.FIRST.getWinningMoney() + "원) -";
    public static final String SECOND_MSG = "5개 일치, 보너스 볼 일치 (" +Rank.SECOND.getWinningMoney() + "원) -";
    public static final String THIRD_MSG = "5개 일치 (" + Rank.THIRD.getWinningMoney() + "원) -";
    public static final String FOURTH_MSG = "4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원) -";
    public static final String FIFTH_MSG = "3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원) -";

    public void lottoNumberView(List<LottoPaper> lottos) {
        for (LottoPaper lottoPaper : lottos) {
            System.out.println(lottoPaper.getLottoNumber());
        }
    }

    public void purchaseLottoView(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void winningResult(Statistics statistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (Rank rank : Rank.values()) {
            resultMsg(rank, statistics.winningCount(rank));
        }
        System.out.println("총 수익률은 " + String.format("%.2f", statistics.earnMoneyRate()) + " 입니다.");
    }

    private void resultMsg(Rank rank, int count) {
        if (rank.equals(Rank.FIRST)) {
            System.out.println(FIRST_MSG + count + "개");
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.println(SECOND_MSG + count + "개");
        }
        if (rank.equals(Rank.THIRD)) {
            System.out.println(THIRD_MSG + count + "개");
        }
        if (rank.equals(Rank.FOURTH)) {
            System.out.println(FOURTH_MSG + count + "개");
        }
        if (rank.equals(Rank.FIFTH)) {
            System.out.println(FIFTH_MSG + count + "개");
        }
    }

}
