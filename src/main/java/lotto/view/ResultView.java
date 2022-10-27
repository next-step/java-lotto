package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinnigType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ResultView {

    private static final String START_LOTTO = "[";
    private static final String END_LOTTO = "]";
    private static final String SEPARATOR = ", ";
    private static final String BOUNDARY = "---------";

    public void printLottoCnt(int cnt) {
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(START_LOTTO + StringUtils.join(lotto.getLotto(), SEPARATOR) + END_LOTTO));
    }

    public void printStatistics(Map<WinnigType, Integer> statisticsMap) {
        statisticsMap.forEach((winnigType, cnt)
                -> System.out.println(winnigType.getMatchCnt() + "개 일치 (" + winnigType.getWinningAmount() + "원)- " + cnt + "개"));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }

    public void printResultMent() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println(BOUNDARY);
    }
}
