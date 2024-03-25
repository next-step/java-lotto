package lotto.ui;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

public class ResultView {

    public void printPurchaseCount(List<LottoTicket> lottoTickets) {
        System.out.println(String.format("%s개를 구매했습니다.", lottoTickets.size()));
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(String.format("[%s]", lottoTicket.toString()));
        }
    }

    public void printMatchResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계\n ---------");
        System.out.println(String.format("%s개 일치 (%s원) - %s개", LottoRank.FOURTH.getMatchCount(), LottoRank.FOURTH.getReward(), result.get(LottoRank.FOURTH)));
        System.out.println(String.format("%s개 일치 (%s원) - %s개", LottoRank.THIRD.getMatchCount(), LottoRank.THIRD.getReward(), result.get(LottoRank.THIRD)));
        System.out.println(String.format("%s개 일치 (%s원) - %s개", LottoRank.SECOND.getMatchCount(), LottoRank.SECOND.getReward(), result.get(LottoRank.SECOND)));
        System.out.println(String.format("%s개 일치 (%s원) - %s개", LottoRank.FIRST.getMatchCount(), LottoRank.FIRST.getReward(), result.get(LottoRank.FIRST)));
    }

    public void printRateResult(double rate) {
        System.out.println(String.format("총 수익률은 %.2f 입니다.", rate));
    }
}
