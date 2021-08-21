package step2.view;

import step2.domain.Award;
import step2.domain.LottoTickets;
import step2.domain.Ticket;
import step2.domain.WinningResults;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {

    public static void announceTotalLottoTicketCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void announceTotalLottoNumbers(LottoTickets lottoTickets) {
        List<Ticket> tickets = lottoTickets.getLottoTickets();

        for (Ticket ticket : tickets) {
            System.out.println(ticket.getLottoNumbers().stream()
                    .collect(Collectors.toList())
            );
        }
    }

    public static void resultStart() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void WinningResult(WinningResults winningResults) {
        Map<Award, Integer> winningResult = winningResults.getWinningResult();
        Arrays.stream(Award.values())
                .filter(award -> !award.equals(Award.MISS))
                .forEach(award ->
                        System.out.println(award.getCountOfMatch() + "개 일치 " +
                                "(" + award.getWinningMoney() + "원)- " +
                                winningResult.getOrDefault(award, 0) + "개"
                        )
                );

        System.out.println("총 수익률은 " + String.format("%.2f", winningResults.getRateOfReturn()) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
