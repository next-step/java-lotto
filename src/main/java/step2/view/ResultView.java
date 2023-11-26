package step2.view;

import step2.domain.*;

import java.util.*;

public class ResultView {
    public static void printLottoCount(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
    }

    public static void printLottoTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.print("[");
            printLottoNumber(ticket);
            System.out.println("]");
            System.out.println();
        }
    }

    private static void printLottoNumber(LottoTicket ticket) {
        ArrayList<LottoNumber> tmpTicket = new ArrayList<>(ticket.lottoNumbers());
        tmpTicket.forEach(lottoNumber -> {
            System.out.print(lottoNumber.number());
            if( tmpTicket.indexOf(lottoNumber) != LottoTicket.LOTTO_NUM_COUNT-1) {System.out.print(", ");}
        });
    }

    public static void printLottoResult(int ticketMoney, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRank.VALUES).forEach(rank -> {
            System.out.println(rank.matchCount()+"개 일치" + "(" + rank.reward() + "원) - " + lottoResult.matchCount(rank));
        });
        System.out.println("총 수익률은 " + new LottoProfit(lottoResult.result()).profit(ticketMoney) + "입니다.");
    }

    public static void printLottoCountNum(int manualCount, int autoCount) {
        System.out.println("수동으로 " + manualCount + "장, 자동으로 " + autoCount + "개를 구매했습니다.");
    }
}
