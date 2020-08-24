package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoConfig;
import step3.domain.Lottos;
import step3.domain.Winnings;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {

    public static final int BREAK_EVEN_POINT = 1;
    public static final String EMPTY = "";

    public static void printLottoPurchaseCount(int lottoPurchaseCount) {
        System.out.println(MessageFormat.format("{0}개를 구매했습니다.", lottoPurchaseCount));
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public static void printWinningCountStatistics(Map<Integer, Integer> calculateWinningCountStatistics) {
        IntStream.range(LottoConfig.WINNING_COUNT_FROM, LottoConfig.WINNING_COUNT_TO + 1)
                .forEach(winningCount -> System.out.println(MessageFormat.format("{0}개 일치 ({1}원)- {2}개", winningCount, Winnings.calculateWinnings(winningCount), calculateWinningCountStatistics.get(winningCount))));
    }

    public static void printYield(double yield) {
        System.out.println(MessageFormat.format("총 수익률은 {0}입니다.{1}", yield, yield < BREAK_EVEN_POINT ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : EMPTY));

    }

}
