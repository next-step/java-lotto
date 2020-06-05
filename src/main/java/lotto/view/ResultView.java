package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.ResultDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView implements View {

    private static final String STATISTICS_START_TEXT = "당첨 통계";

    @Override
    public void view(Object o) {
        ResultDTO resultDTO = (ResultDTO) o;
        Map<Prize, List<Lotto>> result = resultDTO.getResult();
        double profitRatio = resultDTO.getProfitRatio();

        printStatistics(result);
        printProfit(profitRatio);

    }

    private void printStatistics(Map<Prize, List<Lotto>> resultMap) {
        System.out.println(STATISTICS_START_TEXT);
        System.out.println("---------");

        resultMap.keySet().stream().sorted(Comparator.comparingInt(Prize::getWinningPrize)).forEach(prize -> {
            printPrize(prize);
            printWinningCount(resultMap, prize);
        });
    }

    private void printPrize(Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(prize.getMatchCount())
                .append("개 일치");

        if (prize.isSecondPrize(prize)) {
            stringBuffer.append(", 보너스 볼 일치");
        }

        stringBuffer.append("(")
                .append(prize.getWinningPrize())
                .append("원)- ");

        System.out.print(stringBuffer.toString());
    }

    private void printWinningCount(Map<Prize, List<Lotto>> resultMap, Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultMap.get(prize).size())
                .append("개");

        System.out.println(stringBuffer.toString());
    }

    private void printProfit(double profitRatio) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("총 수익률은 ")
                .append(profitRatio)
                .append("입니다.");

        System.out.println(stringBuffer.toString());
    }
}
