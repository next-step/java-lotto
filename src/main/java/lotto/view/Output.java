package lotto.view;

import lotto.model.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Output {
    private static final String LOTTO_CNT_INFO = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATICS = "당첨통계\n---------";
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void printLottoCnt(int cnt){
        System.out.println(cnt+LOTTO_CNT_INFO);
    }

    public static void printWinningStatics(Money buyPrice, LottoResult lottoResult){
        System.out.println(LOTTO_WINNING_STATICS);

        Map<Rank, Long> rankMap = lottoResult.getRankTreeMap();
        for (Map.Entry<Rank, Long> entry: rankMap.entrySet()) {
            Rank rank = entry.getKey();
            Long value = entry.getValue();
            printRankAndValue(rank, value);
        }

        System.out.printf("총 수익룰은 %.2f 입니다.", lottoResult.getProfitRate(buyPrice));
    }

    private static void printRankAndValue(Rank rank, Long value) {
        if(rank == Rank.SECOND){
            System.out.printf("%s개 일치, 보너스 볼 일치(%s원)- %s개\n", "5", rank.getReward(), value);
            return;
        }
        System.out.printf("%s개 일치 (%s원)- %s개\n", rank.getCoincidence(), rank.getReward(), value);
    }

    public static void printLottoTicketList(List<LottoTicket> manualLottoTickets, List<LottoTicket> autoLottoTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",manualLottoTickets.size(), autoLottoTickets.size());
        for (LottoTicket lottoTicket: manualLottoTickets) {
            System.out.println(lottoTicket);
        }
        for (LottoTicket lottoTicket: autoLottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
