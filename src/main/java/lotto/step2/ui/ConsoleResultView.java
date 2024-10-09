package lotto.step2.ui;

import lotto.step2.domain.LottoRank;
import lotto.step2.domain.LottoResult;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.ProfitStatus;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultView{
    public static final String LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---------";
    private static final String LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_RANK_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String LOTTO_PROFIT_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String LOTTO_PROFIT_STATUS_SAME_MESSAGE = "(기준이 1이기 때문에 결과적으로 본전이라는 의미임)";
    private static final String LOTTO_PROFIT_STATUS_GAIN_MESSAGE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
    private static final String LOTTO_PROFIT_STATUS_LOSE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public void showLottoCount(int count){
        System.out.printf(LOTTO_COUNT_MESSAGE, count);
    }

    public void showLottos(Lottos lottos){
        System.out.println(lottos.showLottos());
    }

    public void showLottoResult(LottoResult lottoResult){
        System.out.println(LOTTO_RESULT_MESSAGE);
        EnumMap<LottoRank, Integer> rankInfo = lottoResult.getRankInfo();

        List<LottoRank> ranks = sortLottoRankByMatchCount();
        for (LottoRank rank : ranks) {
            System.out.printf(LOTTO_RANK_MESSAGE, rank.getMatchCount(), rank.getPrize(), rankInfo.get(rank));
        }
    }

    private List<LottoRank> sortLottoRankByMatchCount() {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNoneRank)
                .sorted((o1, o2) -> o1.getMatchCount() - o2.getMatchCount())
                .collect(Collectors.toList());
    }

    public void showLottoProfit(double profitRate) {
        System.out.printf(LOTTO_PROFIT_MESSAGE, profitRate);
    }

    public void showProfitStatus(ProfitStatus status) {
        if(status == ProfitStatus.SAME){
            System.out.println(LOTTO_PROFIT_STATUS_SAME_MESSAGE);
            return;
        }

        if(status == ProfitStatus.LOSS){
            System.out.println(LOTTO_PROFIT_STATUS_LOSE_MESSAGE);
        }

        if(status == ProfitStatus.GAIN){
            System.out.println(LOTTO_PROFIT_STATUS_GAIN_MESSAGE);
        }
    }
}
