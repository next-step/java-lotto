package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistic;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;

public class ResultView {

    private static final String RESULT_MESSAGE_PRE = "당첨 통계";
    private static final String RESULT_MESSAGE_LINE = "--------";
    private static final String RESULT_MESSAGE_POST_BUY = "개를 구매했습니다.";
    private static final String RESULT_DETAIL_TEMPLATE = "%d 개일치 (%d원) - %d개";
    private static final String RESULT_BONUS_DETAIL_TEMPLATE = "%d 개일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String RESULT_PROFIT_TEMPLATE = "총 수익률은 %s입니다.";

    private ResultView() {
    }

    public static void showBuyLottoTickets(final LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        showBuyCountInfo(lottoTicketList.size());
        for (LottoTicket lottoTicket : lottoTicketList) {
            System.out.println(lottoTicket);
        }
    }

    private static void showBuyCountInfo(final int count) {
        System.out.println(count + RESULT_MESSAGE_POST_BUY);
    }

    public static void showLottoResult(final LottoStatistic lottoStatistic, final long amount) {
        System.out.println();
        System.out.println(RESULT_MESSAGE_PRE);
        System.out.println(RESULT_MESSAGE_LINE);

        showLottoStatistic(lottoStatistic);
        showLottoProfitRate(lottoStatistic, amount);
    }

    private static void showLottoStatistic(final LottoStatistic lottoStatistic) {
        showLottoMatchInfo(lottoStatistic, LottoRank.FIFTH_PLACE, RESULT_DETAIL_TEMPLATE);
        showLottoMatchInfo(lottoStatistic, LottoRank.FOURTH_PLACE, RESULT_DETAIL_TEMPLATE);
        showLottoMatchInfo(lottoStatistic, LottoRank.THIRD_PLACE, RESULT_DETAIL_TEMPLATE);
        showLottoMatchInfo(lottoStatistic, LottoRank.SECOND_PLACE, RESULT_BONUS_DETAIL_TEMPLATE);
        showLottoMatchInfo(lottoStatistic, LottoRank.FIRST_PLACE, RESULT_DETAIL_TEMPLATE);
    }

    private static void showLottoMatchInfo(final LottoStatistic lottoStatistic,
                                           final LottoRank lottoRank,
                                           final String template) {
        System.out.printf(
                template,
                lottoRank.getMatchCount(),
                lottoRank.getAmount(),
                lottoStatistic.getRankCount(lottoRank)
        );
        System.out.println();
    }

    private static void showLottoProfitRate(final LottoStatistic lottoStatistic, final long amount) {
        Double profitRate = lottoStatistic.getProfitRate(amount);
        System.out.printf(RESULT_PROFIT_TEMPLATE + System.lineSeparator(), String.format("%.2f", profitRate));
    }
}
