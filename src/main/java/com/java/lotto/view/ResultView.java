package com.java.lotto.view;

import com.java.lotto.domain.Lotto;
import com.java.lotto.domain.LottoReward;
import com.java.lotto.domain.LottoTicket;

import java.util.Map;

public class ResultView {
    private static final String WIN_STATS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String INCOME_FORMAT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void outputOfPurchaseList(Lotto lotto) {
        System.out.println(lotto.getLottoTicketsCount() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lotto.getLottoTickets()) {
            System.out.println(lottoTicket.lottoNumbersToString());
        }
        changeNextLine();

    }

    public static void outputOfWinStats(Lotto lotto) {
        changeNextLine();
        System.out.println("당첨 통계");
        System.out.println("---------");

        int sum = 0;
        for(LottoReward lottoReward : lotto.rank()){
            System.out.println(String.format(WIN_STATS_FORMAT
                    , lottoReward.getMatchNumber()
                    , lottoReward.getLottoMoney()
                    , lotto.numberOfRank(lottoReward)));
        }
        System.out.println(String.format(INCOME_FORMAT, lotto.rateOfReturn()));
    }


    private static void changeNextLine() {
        System.out.println();
    }

}
