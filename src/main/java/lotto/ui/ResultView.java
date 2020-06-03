package lotto.ui;

import lotto.domain.lotto.Lotto;
import lotto.domain.prize.Prize;

import java.util.List;
import java.util.Map;

public class ResultView {
    private ResultView() {}

    public static void printLottoQuantity(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printLottoTicket(List<Lotto> lottoTicket) {
        for(Lotto lotto: lottoTicket){
            System.out.println(lotto);
        }
    }

    public static void printWinStatistics(Map<Integer, Integer> matchCountMap) {
        System.out.println("당첨 통계\n————");
        for (Prize prize : Prize.values()) {
            int matchCount = matchCountMap.getOrDefault(prize.getMatch(), 0);
            System.out.println(prize.getMatch() + "개 일치(" + prize.getPrice() + "원) - "+matchCount +"개");
        }
    }

    public static void printWinRate(double winRate) {
        String result = winRate < 1 ? "손해" : "이득";
        System.out.println("총 수익률은 " + winRate + "입니다.");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + result + "의 의미임)");
    }
}
