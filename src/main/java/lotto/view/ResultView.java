package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import java.util.List;
import java.util.Map;

public class ResultView {
    public void showBuyingCount(int buyingCount) {
        System.out.println(buyingCount + "개를 구매했습니다.");
    }
    
	public void showPickNumbers(List<Lotto> lottos) {
		for(Lotto lotto : lottos) {
		    System.out.println(lotto.toString());
        }
	}

    public void showStatistics(Map<LottoRank, Integer> ranks) {
        System.out.println("\n당첨 통계\n---------");
        System.out.println(LottoRank.FOURTH.getMatchCount() + "개 일치 (" + LottoRank.FOURTH.getPrizeMoney() + "원)- " + ranks.getOrDefault(LottoRank.FOURTH, 0) + "개");
        System.out.println(LottoRank.THIRD.getMatchCount() + "개 일치 (" + LottoRank.THIRD.getPrizeMoney() + "원)- " + ranks.getOrDefault(LottoRank.THIRD, 0) + "개");
        System.out.println(LottoRank.SECOND.getMatchCount() + "개 일치 (" + LottoRank.SECOND.getPrizeMoney() + "원)- " + ranks.getOrDefault(LottoRank.SECOND, 0) + "개");
        System.out.println(LottoRank.FIRST.getMatchCount() + "개 일치 (" + LottoRank.FIRST.getPrizeMoney() + "원)- " + ranks.getOrDefault(LottoRank.FIRST, 0) + "개");
    }

    public void showRateOfReturns(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
