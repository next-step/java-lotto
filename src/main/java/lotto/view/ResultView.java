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
    private static final String RESULT_PROFIT_TEMPLATE = "총 수익률은 %s입니다.";

    private ResultView() {
    }

    public static void showBuyLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        showBuyCountInfo(lottoTicketList.size());
        for (LottoTicket lottoTicket : lottoTicketList) {
            System.out.println(lottoTicket);
        }
    }

    private static void showBuyCountInfo(int count) {
        System.out.println(count + RESULT_MESSAGE_POST_BUY);
    }

    public static void showLottoResult(LottoStatistic lottoStatistic, long amount) {
        System.out.println();
        System.out.println(RESULT_MESSAGE_PRE);
        System.out.println(RESULT_MESSAGE_LINE);

        showLottoStatistic(lottoStatistic);
        showLottoProfitRate(lottoStatistic, amount);
    }

    private static void showLottoStatistic(LottoStatistic lottoStatistic) {
        showLottoMatchInfo(lottoStatistic, LottoRank.FOURTH_PLACE);
        showLottoMatchInfo(lottoStatistic, LottoRank.THIRD_PACE);
        showLottoMatchInfo(lottoStatistic, LottoRank.SECOND_PLACE);
        showLottoMatchInfo(lottoStatistic, LottoRank.FIRST_PLACE);
    }

    private static void showLottoMatchInfo(LottoStatistic lottoStatistic, LottoRank lottoRank) {
        System.out.printf(
                RESULT_DETAIL_TEMPLATE,
                lottoRank.getMatchCount(),
                lottoRank.getAmount(),
                lottoStatistic.getRankCount(lottoRank)
        );
        System.out.println();
    }

    private static void showLottoProfitRate(LottoStatistic lottoStatistic, long amount) {
        Double profitRate = lottoStatistic.getProfitRate(amount);
        System.out.printf(RESULT_PROFIT_TEMPLATE + "%n", String.format("%.2f", profitRate));
    }
}
