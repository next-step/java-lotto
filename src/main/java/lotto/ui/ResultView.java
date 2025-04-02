package lotto.ui;

import lotto.LottoTicket;
import lotto.LottoTickets;
import lotto.Rank;
import lotto.WinningResult;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.Rank.*;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println("수동으로 " + lottoTickets.getManualTicketCount() + "장, 자동으로 " + lottoTickets.getAutoTicketCount() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
        System.out.println();
    }

    public static void printResult(LottoTickets lottoTickets, WinningResult winningResult) {
        List<Rank> ranks = lottoTickets.getLottoTickets().stream()
                .map(winningResult::calculateRank)
                .collect(Collectors.toList());

        long rank5Count = ranks.stream().filter(FIFTH::equals).count();
        long rank4Count = ranks.stream().filter(FOURTH::equals).count();
        long rank3Count = ranks.stream().filter(THIRD::equals).count();
        long rank2Count = ranks.stream().filter(SECOND::equals).count();
        long rank1Count = ranks.stream().filter(FIRST::equals).count();

        long totalPrize = rank5Count * FIFTH.getPrize() + rank4Count * FOURTH.getPrize() + rank3Count * THIRD.getPrize()
                + rank2Count * SECOND.getPrize() + rank1Count * FIRST.getPrize();
        double totalPrizeRate = (double) totalPrize / (lottoTickets.getLottoTicketCount() * LottoTicket.PRICE);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + FIFTH.getPrize() + "원)- " + rank5Count + "개");
        System.out.println("4개 일치 (" + FOURTH.getPrize() + "원)- " + rank4Count + "개");
        System.out.println("5개 일치 (" + THIRD.getPrize() + "원)- " + rank3Count + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + SECOND.getPrize() + "원)- " + rank2Count + "개");
        System.out.println("6개 일치 (" + FIRST.getPrize() + "원)- " + rank1Count + "개");
        System.out.printf("총 수익률은 %.2f입니다.", totalPrizeRate);
        System.out.println(getPrizeRateMessage(totalPrizeRate));
    }

    private static String getPrizeRateMessage(double totalPrizeRate) {
        if (totalPrizeRate == 1) {
            return "(본전입니다.)";
        }
        return totalPrizeRate > 1 ? "(기준이 1이기 때문에 결과적으로 이익이라는 의미임)" : "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    }
}
