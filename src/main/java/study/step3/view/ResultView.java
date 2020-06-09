package study.step3.view;

import study.step3.domain.*;

import java.util.List;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        countTotalLottoTickets(lottoTickets);
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket lottoTicket : tickets){
            System.out.println(lottoTicket.getLottoNumbersForPrint());
        }
    }

    private static void countTotalLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format("%d개를 구매했습니다.",lottoTickets.countLottoTickets()));
    }

    public static void printLottoResult(WinningRanks winningRanks) {
        for (WinningRank rank : WinningRank.values()){
            if (WinningRank.NOTHING.equals(rank)){
                continue;
            }
            System.out.println(String.format("[%s] %d개 일치 (%d원)- %d개",
                    rank.name(),rank.getMatchingCount(),rank.getPrizeMoney(),winningRanks.countRank(rank)));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.",winningRanks.calculateEarningsRate()));
    }
}