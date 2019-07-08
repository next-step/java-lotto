package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;

import java.util.List;

import static lotto.domain.LottoRank.*;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ResultView {
    private static final String PURCHASED_LOTTO_TICKETS_TOTAL_SUFFIX_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String WIN_STATS_MESSAGE_FORMAT = "당첨 통계";
    private static final String YIELDS_MESSAGE_FORMAT = "총 수익률은 %1.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchasedLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + PURCHASED_LOTTO_TICKETS_TOTAL_SUFFIX_MESSAGE);

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    public static void printWinStatistics(LottoResult lottoResult) {
        newLine();
        System.out.println(WIN_STATS_MESSAGE_FORMAT);
        System.out.println("---------");

        System.out.println(String.format(RESULT_MESSAGE_FORMAT, FOURTH.getMatchCount(), FOURTH.getPrizes(), lottoResult.match(FOURTH)));
        System.out.println(String.format(RESULT_MESSAGE_FORMAT, THIRD.getMatchCount(), THIRD.getPrizes(), lottoResult.match(THIRD)));
        System.out.println(String.format(RESULT_MESSAGE_FORMAT, SECOND.getMatchCount(), SECOND.getPrizes(), lottoResult.match(SECOND)));
        System.out.println(String.format(RESULT_MESSAGE_FORMAT, FIRST.getMatchCount(), FIRST.getPrizes(), lottoResult.match(FIRST)));

        System.out.println(String.format(YIELDS_MESSAGE_FORMAT, lottoResult.calculateYields()));
    }

    private static void newLine() {
        System.out.println();
    }
}
