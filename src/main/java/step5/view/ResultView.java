package step5.view;

import step5.domain.LottoNumber;
import step5.domain.LottoTicket;
import step5.domain.LottoTickets;
import step5.domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_LOTTO_INFO_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    public static void printPurchaseLottoInfo(Integer numberOfManualLottoTicketPurchased, int numberOfAutoLottoTicketPurchased) {
        System.out.printf(PURCHASE_LOTTO_INFO_MESSAGE, numberOfManualLottoTicketPurchased, numberOfAutoLottoTicketPurchased);
        System.out.println();
    }


    public static void printLottoNumberInfo(LottoTickets lottoTickets) {
        lottoTickets.tickets()
                .stream()
                .map(ResultView::printByTicket)
                .forEach(System.out::println);
    }

    private static String printByTicket(LottoTicket lottoTicket) {
        return lottoTicket.ticket()
                .stream()
                .map(ResultView::printByNumber)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static String printByNumber(LottoNumber lottoNumber) {
        return Integer.toString(lottoNumber.number());
    }


    public static void printResult(Map<Rank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrize = 0;
        int totalLottoNum = 0;
        for (Rank rank: result.keySet()) {
            System.out.printf("%s개 일치 (%s원)- %s개",rank.getCountOfMatch(), rank.getWinningMoney(), result.get(rank));
            if (result.get(rank) >= 1) {
                totalPrize += rank.getWinningMoney() * result.get(rank);
                totalLottoNum += result.get(rank);
            }
            System.out.println();
        }

        if (totalPrize > totalLottoNum * 1000) {
            System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 이득이라는 의미임)", totalPrize/(double) (totalLottoNum * 1000));
            return;
        }
        if (totalPrize < totalLottoNum * 1000) {
            System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)", totalPrize / (double) (totalLottoNum * 1000));
            return;
        }
        System.out.printf("총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 본전이라는 의미임)", totalPrize / (double) (totalLottoNum * 1000));
    }
}
