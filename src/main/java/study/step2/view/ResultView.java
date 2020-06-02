package study.step2.view;

import study.step2.domain.LottoTicket;
import study.step2.domain.WinningTable;
import study.step2.dto.LottoGameRequestDto;

import java.util.List;

public class ResultView {

    public static void printPurchasedLottoTickets(List<LottoTicket> lottoTickets){
        for (LottoTicket ticket : lottoTickets){
            System.out.println(ticket.getNumbers());
        }
    }

    public static void printWinningStatisTics(LottoGameRequestDto lottoGameRequestDto) {
        System.out.println("당첨 통계");
        for (WinningTable winningTable : WinningTable.values()){
            if (WinningTable.NOTHING.name().equals(winningTable.name())){
                continue;
            }
            System.out.println(String.format("%d개 일치 ( %d원)- %d개", winningTable.getMatchingCount(),
                    winningTable.getPrizeMoney(), lottoGameRequestDto.getMatchingCounts().stream()
                                                                                         .filter(matchingCount -> matchingCount ==winningTable.getMatchingCount())
                                                                                         .count()));
        }
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoGameRequestDto.getEarningsRate()));
    }
}
