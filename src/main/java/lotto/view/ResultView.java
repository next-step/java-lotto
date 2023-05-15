package lotto.view;

import lotto.model.*;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void printLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printWinResult(LottoResult lottoResult) {
        printWinGuideText();

        Map<Rank, Integer> rankMap = lottoResult.getRankResult();
        rankMap.entrySet().stream()
                .filter(entry -> entry.getKey().count() > 0)
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEach(entry -> {
                    Rank rank = entry.getKey();
                    int count = entry.getValue();
                    System.out.printf("%d개 일치 (%d원) - %d개\n", rank.count(), rank.prize(), count);
                });
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets().forEach(ResultView::printLottoTicket);
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        String lottoTicketNumbers = lottoTicket.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

        System.out.println("[" + lottoTicketNumbers + "]");
    }

    private static void printWinGuideText() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printWinRate(LottoResult lottoResult, LottoTickets lottoTickets) {
        double rate = lottoResult.getRateResult(lottoTickets.size());
        System.out.printf("총 수익률은 %.2f 입니다.", rate);
        if (rate < 1) {
            printLossMessage();
        }
    }

    private static void printLossMessage() {
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
