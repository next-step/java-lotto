package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class ResultView {
    private static Map<Rank, Integer> winningResult = new HashMap<>();
    private static double totalMoney;
    public static void lottoTicketView(LottoTicket lottoTicket) {
        for (Lotto lotto: lottoTicket.getLottoTicket()) {
            System.out.println(lotto.toString());
        }
    }
    public static void statisticsView(LottoTicket lottoTicket, LottoMachine lottoMachine, Lotto winningLotto, int number) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        winningResult.put(Rank.FOURTH, 0);
        winningResult.put(Rank.THIRD, 0);
        winningResult.put(Rank.SECOND, 0);
        winningResult.put(Rank.FIRST, 0);

        for (Lotto lotto: lottoTicket.getLottoTicket()) {
            Rank rank = lottoMachine.rank(lotto, winningLotto);
            if (winningResult.containsKey(rank)) {
                int money = winningResult.get(rank) + 1;
                winningResult.replace(rank, money);
            }
        }

        for (Rank key : winningResult.keySet()) {
            Integer value = winningResult.get(key);
            System.out.println(key.getMatchCount() + "개 일치 " + "(" + key.getMoney() + "원)- " + value + "개");
            totalMoney = totalMoney + key.getMoney() * value;
        }
        int investment = number * 1000;
        double profitRate = ((double) totalMoney - investment) / investment * 100;
        System.out.println("총 수익률은 " + profitRate +"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
