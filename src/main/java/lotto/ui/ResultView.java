package lotto.ui;

import lotto.LottoRank;
import lotto.LottoTicket;
import lotto.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.LottoRank.*;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTicketCount() + "개를 구매했습니다.");
        lottoTickets.getLottoTickets().forEach(lottoTicket -> System.out.println(lottoTicket.getLottoNumbers()));
        System.out.println();
    }

    public static void printResult(LottoTickets lottoTickets, LottoTicket winningTicket) {
        List<LottoRank> ranks = lottoTickets.getLottoTickets().stream()
                .map(lottoTicket -> lottoTicket.calculateRank(winningTicket))
                .collect(Collectors.toList());

        long rank5Count = ranks.stream().filter(RANK_5::equals).count();
        long rank4Count = ranks.stream().filter(RANK_4::equals).count();
        long rank3Count = ranks.stream().filter(RANK_3::equals).count();
        long rank1Count = ranks.stream().filter(RANK_1::equals).count();

        long totalPrize = rank5Count * RANK_5.getPrize() + rank4Count * RANK_4.getPrize() + rank3Count * RANK_3.getPrize() + rank1Count * RANK_1.getPrize();
        double totalPrizeRate = (double) totalPrize / (lottoTickets.getLottoTicketCount() * LottoTicket.PRICE);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (" + RANK_5.getPrize() + "원)- " + rank5Count + "개");
        System.out.println("4개 일치 (" + RANK_4.getPrize() + "원)- " + rank4Count + "개");
        System.out.println("5개 일치 (" + RANK_3.getPrize() + "원)- " + rank3Count + "개");
        System.out.println("6개 일치 (" + RANK_1.getPrize() + "원)- " + rank1Count + "개");
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
