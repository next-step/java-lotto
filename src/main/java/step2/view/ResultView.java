package step2.view;

import java.util.List;
import java.util.Map;

import step2.domain.LottoResult;
import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.WinningRank;

public class ResultView {
    private final static String PURCHASED_LOTTOS_COUNTING = "%d개를 구매했습니다.";
    private final static String LOTTO_RESULTS = "%d개 일치 (%d원)- %d개";
    private final static String LOTTO_RESULT_EARNINGS_RATE = "총 수익률은 %.2f입니다.";
    private final static String EARNINGS_RATE = "earningsRate";

    private ResultView() {
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        countTotalLottoTickets(lottoTickets);
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : tickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    private static void countTotalLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format(PURCHASED_LOTTOS_COUNTING, lottoTickets.countLottoTickets()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        Map<String, Object> map = lottoResult.getResult();
        for (WinningRank winningRank : WinningRank.values()) {
            System.out.println(String.format(LOTTO_RESULTS, winningRank.getMatchingCount(winningRank), winningRank.getPrizeMoney(), lottoResult.countRank(winningRank)));
        }
        System.out.println(String.format(LOTTO_RESULT_EARNINGS_RATE, map.get(EARNINGS_RATE)));
    }
}