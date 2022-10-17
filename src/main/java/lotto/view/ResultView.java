package lotto.view;

import lotto.constant.LottoRanking;
import lotto.domain.LottoCount;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.List;
import java.util.Map;

public class ResultView {
    public void printLottoCount(LottoCount lottoCount) {
        System.out.println(lottoCount.getCount() + "개를 구매했습니다.");
    }

    public void printAllLottoNumbers(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
        System.out.println();
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("--------------");

        for (Map.Entry<Integer, Integer> entry : lottoResult.getLottoRankings().entrySet()) {
            System.out.println(entry.getKey() + "개 일치 (" + LottoRanking.getAward(entry.getKey()) + "원) - " + entry.getValue() + "개");
        }

        System.out.println("총 수익률은 " + lottoResult.getWinPercentage() + "입니다.");
    }
}
