package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.ResultDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView implements View {

    private static final String STATISTICS_START_TEXT = "당첨 통계";
    private static final String TEXT_SEPARATOR = "---------";
    private static final String MATCH_COUNT_POSTFIX = "개 일치";
    private static final String MATCH_BONUS_NUMBER_POSTFIX = ", 보너스 볼 일치";
    private static final String PRIZE_PREFIX = "(";
    private static final String PRIZE_POSTFIX = "원)- ";
    private static final String MATCH_PRIZE_POSTFIX = "개";
    private static final String PROFIT_RATIO_PREFIX = "총 수익률은 ";
    private static final String PROFIT_RATIO_POSTFIX = "입니다.";

    @Override
    public void view(Object o) {
        ResultDTO resultDTO = (ResultDTO) o;
        Map<Prize, Integer> result = resultDTO.getResult();
        double profitRatio = resultDTO.getProfitRatio();

        printStatistics(result);
        printProfit(profitRatio);

    }

    private void printStatistics(Map<Prize, Integer> resultMap) {
        System.out.println(STATISTICS_START_TEXT);
        System.out.println(TEXT_SEPARATOR);

        resultMap.keySet().stream().sorted(Comparator.comparingInt(Prize::getWinningPrize)).forEach(prize -> {
            printPrize(prize);
            printWinningCount(resultMap, prize);
        });
    }

    private void printPrize(Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(prize.getMatchCount())
                .append(MATCH_COUNT_POSTFIX);

        if (prize.isSecondPrize(prize)) {
            stringBuffer.append(MATCH_BONUS_NUMBER_POSTFIX);
        }

        stringBuffer.append(PRIZE_PREFIX)
                .append(prize.getWinningPrize())
                .append(PRIZE_POSTFIX);

        System.out.print(stringBuffer.toString());
    }

    private void printWinningCount(Map<Prize, Integer> resultMap, Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultMap.get(prize))
                .append(MATCH_PRIZE_POSTFIX);

        System.out.println(stringBuffer.toString());
    }

    private void printProfit(double profitRatio) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(PROFIT_RATIO_PREFIX)
                .append(profitRatio)
                .append(PROFIT_RATIO_POSTFIX);

        System.out.println(stringBuffer.toString());
    }
}
