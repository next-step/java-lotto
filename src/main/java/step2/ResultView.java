package step2;

import java.util.Map;

public class ResultView {
    public void previewLottoGames(LottoGame lottoGame) {
        System.out.println(lottoGame.getTicketCount() + "개를 구매했습니다.");
        lottoGame.getLottoTickets().forEach(System.out::println);
    }

    public void printResult(LottoGame lottoGame) {
        final Map<MatchCount, Long> results = lottoGame.getResults();
        System.out.println("당첨 통계\n---------");
        results.forEach((matchCount, winCount) -> System.out.printf("%d개 일치 (%d원)- %d개\n",
                matchCount.getMatchCount(),
                matchCount.getPrize(),
                winCount));
        System.out.println("총 수익률은 " + lottoGame.getProfitRate() + "입니다.");
    }
}
