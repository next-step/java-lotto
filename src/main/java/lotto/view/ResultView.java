package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

public class ResultView {
    public void showBuyingCount(int buyingCount) {
        System.out.println(buyingCount + "개를 구매했습니다.");
    }
    
	public void showPickNumbers(LottoTicket lottoTicket) {
		for (Lotto lotto : lottoTicket.getLottos()) {
		    System.out.println(lotto.print());
        }
	}

    public void showStatistics(LottoResult lottoResult) {
        System.out.println("\n당첨 통계\n---------");
        System.out.println(LottoRank.FIFTH.getMatchCount() + "개 일치 (" + LottoRank.FIFTH.getPrizeMoney() + "원)- " + lottoResult.getMatchCount(LottoRank.FIFTH) + "개");
        System.out.println(LottoRank.FOURTH.getMatchCount() + "개 일치 (" + LottoRank.FOURTH.getPrizeMoney() + "원)- " + lottoResult.getMatchCount(LottoRank.FOURTH) + "개");
        System.out.println(LottoRank.THIRD.getMatchCount() + "개 일치 (" + LottoRank.THIRD.getPrizeMoney() + "원)- " + lottoResult.getMatchCount(LottoRank.THIRD) + "개");
        System.out.println(LottoRank.SECOND.getMatchCount() + "개 일치, 보너스 볼 일치(" + LottoRank.SECOND.getPrizeMoney() + "원)- " + lottoResult.getMatchCount(LottoRank.SECOND) + "개");
        System.out.println(LottoRank.FIRST.getMatchCount() + "개 일치 (" + LottoRank.FIRST.getPrizeMoney() + "원)- " + lottoResult.getMatchCount(LottoRank.FIRST) + "개");
    }

    public void showRateOfReturns(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
