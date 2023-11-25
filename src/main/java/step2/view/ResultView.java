package step2.view;

import step2.domain.*;

import java.util.*;

public class ResultView {
    public void printLottoCount(List<LottoTicket> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
    }

    public void printLottoTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.print("[");
            printLottoNumber(ticket);
            System.out.println("]");
            System.out.println();
        }
    }

    private void printLottoNumber(LottoTicket ticket) {
        ArrayList<LottoNumber> tmpTicket = new ArrayList<>(ticket.lottoNumbers());
        tmpTicket.forEach(lottoNumber -> {
            System.out.print(lottoNumber.number());
            if( tmpTicket.indexOf(lottoNumber) != LottoTicket.LOTTO_NUM_COUNT-1) {System.out.print(", ");}
        });
    }

    public void printLottoResult(int ticketMoney, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        Arrays.stream(LottoRank.VALUES).forEach(rank -> {
            System.out.println(rank.matchCount()+"개 일치" + "(" + rank.reward() + "원) - " + lottoResult.matchCount(rank));
        });
        System.out.println("총 수익률은 " + new LottoProfit(lottoResult.result()).profit(ticketMoney) + "입니다.");
    }
}
