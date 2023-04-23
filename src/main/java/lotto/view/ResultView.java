package lotto.view;

import lotto.domain.LottoReward;
import lotto.domain.WinningStatistics;

import java.util.Map;

public final class ResultView {

    private ResultView() {
        throw new IllegalCallerException("잘못된 객체생성 입니다.");
    }

    public static void showResult(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        Map<LottoReward, Integer> detail = winningStatistics.getDetail();
        LottoReward.getRewardValues()
                .forEach(reward -> showRewards(reward, detail.get(reward)));
        showIncomeRate(winningStatistics.getIncomeRate());
    }

    private static void showIncomeRate(double incomeRate) {
        StringBuilder sb = new StringBuilder(String.format("총 수익률은 %s입니다.", incomeRate));
        if (incomeRate < 1) {
            sb.append("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
        System.out.println(sb);
    }

    private static void showRewards(LottoReward lottoReward, Integer count) {
        System.out.printf("%d개 일치 (%d원)- %d개%n",
                lottoReward.getMatchedCount(),
                lottoReward.getReward(),
                count);
    }

}