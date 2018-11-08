package lotto.view;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoTicket;

public class ResultView {

    public static void renderBuyedTikets(List<LottoTicket> tikets) {
        System.out.println(String.format("%d개를 구매했습니다.", tikets.size()));
        for (LottoTicket tiket : tikets) {
            System.out.println(tiket);
        }
    }

    public static void renderStats(Map<Integer, Integer> stats, int money) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println(String.format("3개 일치 (5000원)- %d개", stats.getOrDefault(3, 0)));
        System.out.println(String.format("4개 일치 (50000원)- %d개", stats.getOrDefault(4, 0)));
        System.out.println(String.format("5개 일치 (1500000원)- %d개", stats.getOrDefault(5, 0)));
        System.out.println(String.format("6개 일치 (2000000000원)- %d개", stats.getOrDefault(6, 0)));
    }

}
