package lotto.view;

import lotto.domain.ResultDTO;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultView implements View {

    private static final int[] winningPrize = {5000, 50000, 1500000, 2000000000};
    private int WINNING_NUMBER_MIN_COUNT = 3;

    @Override
    public void view(Object o) {
        ResultDTO resultDTO = (ResultDTO) o;
        List<Integer> winningList = resultDTO.getWinningList();
        int lottoCount = resultDTO.getMoney();
        printStatistics(winningList, lottoCount);
    }

    private void printStatistics(List<Integer> winningList, int money) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        StringBuffer stringBuffer = new StringBuffer();
        AtomicInteger winningPrizeIndex = new AtomicInteger();

        winningList.stream().forEach( wingRanking -> {
            stringBuffer.append(WINNING_NUMBER_MIN_COUNT++)
                    .append("개 일치 ")
                    .append("(")
                    .append(winningPrize[winningPrizeIndex.getAndIncrement()])
                    .append(")- ")
                    .append(wingRanking)
                    .append("개")
                    .append("\n");
        });

        int prizeSum = calculateProfit(winningList);
        double profitRatio = (double) prizeSum / money;
        stringBuffer.append("총 수익률은 ")
                .append(profitRatio)
                .append("입니다.");

        System.out.println(stringBuffer.toString());
    }

    private int calculateProfit(List<Integer> winningList) {
        AtomicInteger winningPrizeIndex = new AtomicInteger();
        int prizeSum = winningList.stream()
                            .mapToInt(winCount -> calculateWinningList(winCount, winningPrizeIndex.getAndIncrement()))
                            .sum();
        return prizeSum;
    }

    private int calculateWinningList(int winCount, int winningPrizeIndex) {
        if(winCount > 0) {
            return winningPrize[winningPrizeIndex];
        }
        return 0;
    }
}
