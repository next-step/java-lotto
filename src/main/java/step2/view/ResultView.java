package step2.view;

import step2.Lotto;
import step2.Rank;
import step2.WinningTickets;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static String LOTTO_FORMAT = "[%d, %d, %d, %d, %d, %d]";
    private static String RESULT_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static String REVENUE_FORMAT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    public static void showLottos(List<Lotto> lottos){
        lottos.stream()
            .forEach( lotto -> System.out.println(String.format(LOTTO_FORMAT, lotto.getLottoNumbers().toArray())));
    }

    public static void printResult(List<Lotto> lottos, Lotto winningLotto, int payedPrice) {
        System.out.println("당첨 통계\n --------");
        WinningTickets winningTickets = new WinningTickets();
        for (Lotto lotto : lottos) {
            Rank rank = lotto.match(winningLotto);
            winningTickets.addWinner(rank);
        }

        Map<Rank, Integer> winningTicketMap = winningTickets.getWinningTickets();
        String result = "";

        for (Rank rank : winningTicketMap.keySet()) {
            result += String.format(RESULT_FORMAT, rank.getMatchNumberCount(), rank.getReward(), winningTicketMap.get(rank));
        }

        double revenue = winningTickets.revenue(payedPrice);
        result += String.format(REVENUE_FORMAT, revenue, winningTickets.isBenefit(revenue));
        System.out.println(result);
    }
}
