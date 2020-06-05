package lotto.view;

import lotto.domain.Prize;
import lotto.domain.ResultDTO;

import java.util.Map;

public class ResultView implements View {

    @Override
    public void view(Object o) {
        ResultDTO resultDTO = (ResultDTO) o;
        Map<Prize, Integer> result = resultDTO.getResult();
        double profitRatio = resultDTO.getProfitRatio();

        printStatistics(result);
        printProfit(profitRatio);

    }

    private void printStatistics(Map<Prize, Integer> resultMap) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        resultMap.keySet().stream().forEach(prize -> {
            printPrize(prize);
            printWinningCount(resultMap, prize);
        });
    }

    private void printPrize(Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(prize.getMatchCount())
                .append("개 일치")
                .append("(")
                .append(prize.getWinningPrize())
                .append(")- ");

        System.out.print(stringBuffer.toString());
    }

    private void printWinningCount(Map<Prize, Integer> resultMap, Prize prize) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(resultMap.get(prize))
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
