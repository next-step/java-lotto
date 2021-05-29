package lotto.view;

import lotto.LottoRank;
import lotto.LottoRecord;
import lotto.Lottos;

import java.util.Arrays;
import java.util.Map;

public class ResultView {
    private static final String LOTTO_BUY_RESULT_OUTPUT = "%d개를 구매하셨습니다.\n";
    private static final String WIN_STATISTICS = "당첨 통계";
    private static final String BONUS_REWARD_REMARK = "%d개 일치, 보너스 볼 일치(%d원)- %d개\n";
    private static final String REWARD_REMARK = "%d개 일치 (%d원)- %d개\n";
    private static final String REMARK = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void buyLottoInfo(Lottos userLottos) {
        System.out.printf(LOTTO_BUY_RESULT_OUTPUT, userLottos.getCount());
        System.out.println(userLottos.toString());
    }

    public static void printResult(LottoRecord userLottoRecord) {
        System.out.println();
        System.out.println(WIN_STATISTICS);
        System.out.println("---------");
        Map<LottoRank, Long> result = userLottoRecord.calculateReward();
        Arrays.stream(LottoRank.values())
                .filter(lottoRank ->  !lottoRank.isMiss())
                .forEach(lottoRank -> printRewardRemark(lottoRank, result));
        System.out.printf(REMARK, userLottoRecord.getProfit());
    }

    private static void printRewardRemark(LottoRank lottoRank, Map<LottoRank, Long> result) {
        if (lottoRank.isSecond()) {
            System.out.printf(BONUS_REWARD_REMARK, lottoRank.getMatchCount(), lottoRank.getWinReward(), result.getOrDefault(lottoRank, 0l));
            return;
        }
        System.out.printf(REWARD_REMARK, lottoRank.getMatchCount(), lottoRank.getWinReward(), result.getOrDefault(lottoRank, 0l));
    }
}
