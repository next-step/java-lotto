package lotto.view;

import lotto.domain.value.LottoResult;
import lotto.domain.value.LottoTickets;
import lotto.domain.value.Rank;

import java.util.Map;

public class OutView {
    private static final String PURCHASE_COUNT_MESSAGE = "%s개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS = "당첨통계\n";
    private static final String HORIZON = "---------\n";
    private static final String STATISTICS_MESSAGE = "%d개 일치 (%d)- %d개\n";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %f입니다.";


    public static void showLottoTickets(LottoTickets lottoTickets) {
        showNumbersOfTickets(lottoTickets);
        showDetailOfLottoTickets(lottoTickets);
    }

    public static void showLottoResult(LottoResult lottoResult) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(HORIZON);
        showWinningResult(lottoResult);
        showProfitRate(lottoResult);
    }

    private static void showNumbersOfTickets(LottoTickets lottoTickets) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottoTickets.size());
    }

    private static void showDetailOfLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getDetailTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
    }

    private static void showWinningResult(LottoResult lottoResult) {
        Map<Rank, Integer> result = lottoResult.getResult();
        result.entrySet()
                .stream()
                .filter(entry -> entry.getKey() != Rank.OUT)
                .forEach(entry -> {
                    Rank rank = entry.getKey();
                    System.out.printf(STATISTICS_MESSAGE, rank.getMatchCount(), rank.getPrizeMoney(), entry.getValue());
                });
    }

    private static void showProfitRate(LottoResult lottoResult) {
        System.out.printf(PROFIT_RATE_MESSAGE, lottoResult.getProfitRate());
    }
}
