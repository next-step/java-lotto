package step4.view;

import step4.domain.LottoMachine;
import step4.domain.Lottos;
import step4.domain.Rank;

import java.text.MessageFormat;
import java.util.Map;

public class ResultView {

    public static final int BREAK_EVEN_POINT = 1;
    public static final String EMPTY = "";

    public static void printLottoPurchaseCount(LottoMachine lottoMachine) {
        System.out.println();
        System.out.println(MessageFormat.format("수동으로 {0}장, 자동으로 {1}개를 구매했습니다.", lottoMachine.getManualLottosSize(), lottoMachine.getAutoLottosSize()));
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printWinningCountStatistics(Map<Rank, Integer> calculateWinningCountStatistics) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(MessageFormat.format("3개 일치 (5000원)- {0}개", calculateWinningCountStatistics.get(Rank.FIFTH)));
        System.out.println(MessageFormat.format("4개 일치 (50000원)- {0}개", calculateWinningCountStatistics.get(Rank.FOURTH)));
        System.out.println(MessageFormat.format("5개 일치 (1500000원)- {0}개", calculateWinningCountStatistics.get(Rank.THIRD)));
        System.out.println(MessageFormat.format("5개 일치, 보너스 볼 일치(30000000원) - {0}개", calculateWinningCountStatistics.get(Rank.SECOND)));
        System.out.println(MessageFormat.format("6개 일치 (2000000000원)- {0}개", calculateWinningCountStatistics.get(Rank.FIRST)));
    }

    public static void printYield(double yield) {
        System.out.println(MessageFormat.format("총 수익률은 {0}입니다.{1}", yield, yield < BREAK_EVEN_POINT ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : EMPTY));

    }

}
