package study.step3.view;

import study.step3.domain.LottoResult;
import study.step3.domain.LottoTicket;
import study.step3.domain.LottoTickets;
import study.step3.domain.WinningRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private final static String PURCHASED_LOTTOS_COUNTING = "%d개를 구매했습니다.";
    private final static String LOTTO_RESULTS = "%d개 일치 (%d원)- %d개";
    private final static String LOTTO_RESULT_EARNINGS_RATE = "총 수익률은 %.2f입니다.";
    private final static String EARNINGS_RATE = "earningsRate";

    private ResultView(){}

    public static void printLottoTickets(LottoTickets lottoTickets) {
        countTotalLottoTickets(lottoTickets);
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    private static void countTotalLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format(PURCHASED_LOTTOS_COUNTING,lottoTickets.countLottoTickets()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        Map<String, Object> map = lottoResult.getResult();
        for (WinningRank rank : WinningRank.values()){
            System.out.println(String.format(LOTTO_RESULTS,rank.getMatchingCount(),rank.getPrizeMoney(),lottoResult.countRank(rank)));
        }
        System.out.println(String.format(LOTTO_RESULT_EARNINGS_RATE,map.get(EARNINGS_RATE)));
    }
}
