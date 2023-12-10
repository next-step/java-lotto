package lotto_auto.io;

import lotto_auto.domain.LottoNumbers;
import lotto_auto.domain.MatchEnum;
import lotto_auto.domain.WinningNumber;

import java.util.List;

public class OutputView {

    public OutputView(List<LottoNumbers> lottoTotalNumberList) {
        System.out.println(lottoTotalNumberList.size() + "개를 구매했습니다.");
        for (int i = 0; i < lottoTotalNumberList.size(); i++) {
            System.out.println(lottoTotalNumberList.get(i));
        }
    }

    public void printStatistics() {

        System.out.println("\n당첨 통계");
        System.out.println("------------");
        for (MatchEnum match : MatchEnum.values()) {
            System.out.println(match.getMatches() + "개 일치 (" + match.getMoney() + ")- " + WinningNumber.getMatchCntMap().get(match) + "개");
        }

        float totalProfitRate = getTotalProfitRate();
        System.out.println("총 수익률은 " + totalProfitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }

    private static float getTotalProfitRate() {
        int totalProfit = WinningNumber.getMatchCntMap().get(MatchEnum.THREE_MATCHES) * MatchEnum.THREE_MATCHES.getMoney()
                + WinningNumber.getMatchCntMap().get(MatchEnum.FOUR_MATCHES) * MatchEnum.FOUR_MATCHES.getMoney()
                + WinningNumber.getMatchCntMap().get(MatchEnum.FIVE_MATCHES) * MatchEnum.FIVE_MATCHES.getMoney()
                + WinningNumber.getMatchCntMap().get(MatchEnum.SIX_MATCHES) * MatchEnum.SIX_MATCHES.getMoney();
        float totalProfitRate = (float) totalProfit / InputView.initialBudget;
        return totalProfitRate;
    }
}
