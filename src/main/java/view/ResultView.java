package view;

import domain.Lotto;
import domain.LottoPrize;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultView {

    private ResultView() {
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println("");
    }

    public static void printLottoGameResult(Map<Integer, Integer> lottoMatchResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (int i = 3; i < 7; i++) {
            if (lottoMatchResult.get(i) == null) {
                System.out.println(String.format("%d개 일치 (%d원) - 0개",
                        LottoPrize.fromMatchCount(i).getMatchCount(),
                        LottoPrize.fromMatchCount(i).winningPrize()));
                continue;
            }
            System.out.println(String.format("%d개 일치 (%d원) - %d개", i,
                    LottoPrize.fromMatchCount(i).winningPrize(),
                    lottoMatchResult.get(i)));
        }
    }

    public static void printLottoReturnRate(float rate) {
        System.out.println(String.format("총 수익률은 %f 입니다.", rate));
    }
}
