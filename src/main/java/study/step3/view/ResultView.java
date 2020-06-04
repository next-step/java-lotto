package study.step3.view;

import study.step3.domain.LottoResult;
import study.step3.domain.LottoTicket;
import study.step3.domain.LottoTickets;
import study.step3.domain.WinningRank;

import java.util.List;
import java.util.Map;

public class ResultView {
    private final static String LOTTO_RESULT_EARNINGS_RATE = "earningsRate";

    public static void printLottoTickets(LottoTickets lottoTickets) {
        countTotalLottoTickets(lottoTickets);
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }

    private static void countTotalLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format("%d개를 구매했습니다.",lottoTickets.countLottoTickets()));
    }

    public static void printLottoResult(LottoResult lottoResult) {
        Map<String, Object> map = lottoResult.getResult();
        for (WinningRank rank : WinningRank.values()){
            if (WinningRank.NOTHING.equals(rank)){
                continue;
            }
            System.out.println(String.format("[%s] %d개 일치 (%d원)- %d개",rank.name(),rank.getMatchingCount(),rank.getPrizeMoney(),lottoResult.countRank(rank)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.",map.get(LOTTO_RESULT_EARNINGS_RATE)));
    }
}
