package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.WinAmount;
import lotto.dto.WinStats;

import java.util.Map;
import java.util.Set;

public class OutputView {
    private static final String MSG_PURCHASE = "개를 구매했습니다.";
    private static final String MSG_WIN_STATS = "당첨 통계\n" + "---------";
    private static final String MSG_WIN_COUNT = "%d개 일치 (%d원)- %d개\n";
    private static final String MSG_YIELD = "총 수익률은 %.2f입니다.";
    private static final String MSG_YIELD_LOSE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String MSG_YIELD_WIN = "(오늘 로또 사러 갑니다)";

    public void printPurchase(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTickets().size() + MSG_PURCHASE);

        lottoTickets.getLottoTickets()
                .forEach(i -> System.out.println(i.getLottoNumbers().toString()));

    }

    public void printWinStats(WinStats winStats) {
        System.out.println(MSG_WIN_STATS);

        // 일치 통계
        Map<WinAmount, Integer> maps = winStats.getMatchMap();
        Set<WinAmount> keys = maps.keySet();
        keys.forEach(i -> System.out.printf(MSG_WIN_COUNT, i.getMatchCount(), i.getReward(), maps.get(i)));

        // 수익률
        float yield = winStats.getYield();
        System.out.printf(MSG_YIELD, yield);
        System.out.println(getYieldMessage(yield));
    }

    private String getYieldMessage(float yield) {
        if (yield > 1) {
            return MSG_YIELD_WIN;
        }
        return MSG_YIELD_LOSE;
    }
}
