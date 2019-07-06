package com.java.lotto.view;

import com.java.lotto.domain.*;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class ResultView {
    private static final String PURCHASE_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WIN_STATS_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String INCOME_FORMAT = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void outputOfPurchaseList(Lotto lotto) {
        System.out.println(String.format(PURCHASE_FORMAT, lotto.getCountOfManualLotto(), lotto.getCountOfAutoLotto()));
        LottoTickets lottoTickets = lotto.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket.getLottoNumbers().toString());
        }
        changeNextLine();

    }

    public static void outputOfWinStats(WinningStatistics winningStatistics) {
        changeNextLine();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoReward lottoReward : LottoReward.values()) {
            System.out.println(String.format(formatString(lottoReward)
                    , lottoReward.getMatchNumber()
                    , lottoReward.getLottoMoney()
                    , winningStatistics.countByReward(lottoReward)));
        }
        System.out.println(String.format(INCOME_FORMAT, winningStatistics.getWinningRate()));
    }

    private static String formatString(LottoReward lottoReward) {
        return lottoReward == LottoReward.MATCH_FIVE_BONUS ? BONUS_FORMAT : WIN_STATS_FORMAT;
    }

    private static void changeNextLine() {
        System.out.println();
    }

}
