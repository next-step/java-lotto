package lotto.view;

import lotto.LottoRank;
import lotto.LottoRecord;
import lotto.Lottos;

import java.util.Map;

public class ResultView {
    private static final String LOTTO_BUY_RESULT_OUTPUT = "%d개를 구매하셨습니다.\n";
    private static final String WIN_STATISTICS = "당첨 통계";
    private static final String REWARD_REMARK = "%d개 일치 (%d원)- %d개\n";
    private static final String REMARK = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void buyLottoInfo(Lottos lottos) {
        System.out.printf(LOTTO_BUY_RESULT_OUTPUT, lottos.getCount());
        System.out.println(lottos.toString());
    }

    public static void printResult(LottoRecord lottoRecord) {
        System.out.println();
        System.out.println(WIN_STATISTICS);
        System.out.println("---------");
        Map<LottoRank, Long> result = lottoRecord.calculateReward();
        result.forEach(
                (lottoRank, countMatch) -> System.out.printf(REWARD_REMARK, lottoRank.getMatchCount(), lottoRank.getWinReward(), countMatch - 1)
        );
        System.out.printf(REMARK, lottoRecord.getProfit());
    }
}
