package lotto.ui;

import lotto.constant.LottoRank;
import lotto.model.LottoTicket;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ResultView {

    private ResultView() {}

    public static void printLottos(int lottoCount, List<LottoTicket> lottoTicketList) {

        System.out.printf("You got %d lottos\n", lottoCount);
        for (LottoTicket lottoTicket : lottoTicketList) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printResult(Map<LottoRank, Integer> gameResult, double rateReturn) {
        System.out.println("\n당첨 통계\n---------");
        Map<LottoRank, Integer> sortedMap = new TreeMap<>(gameResult).descendingMap();
        for (LottoRank lottoRank : sortedMap.keySet()) {
            if (lottoRank != LottoRank.LOSE) {
                System.out.println(lottoRank.toString(gameResult.get(lottoRank)));
            }
        }
        System.out.printf("총 수익률은 %.2f입니다. ", rateReturn);
        String result = "손해";
        if (rateReturn >= 1) {
            result = "이득";
        }
        System.out.printf("(기준이 1이기 때문에 결과적으로 %s라는 의미임)\n", result);
    }
}
