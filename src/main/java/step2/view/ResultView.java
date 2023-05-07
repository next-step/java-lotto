package step2.view;

import step2.domain.LottoCalculator;
import step2.domain.LottoMatches;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    public static void printNumOfLotto(int countOfLotto) {
        System.out.printf("%d개를 구매했습니다.%n", countOfLotto);
    }

    public static void printLottos(List<List<Integer>> lottos) {
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static String displayWinningStatistics(List<List<Integer>> lottos, List<Integer> winningNumbers, double profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n");
        sb.append("---------\n");

        // 3, 4, 5, 6개 일치한 로또 개수를 저장할 배열
        int[] matchCounts = LottoMatches.getMatchCounts(lottos, winningNumbers);

        IntStream.range(0, matchCounts.length)
                .forEach(i -> {
                    int count = matchCounts[i];
                    int matchedCountIndex = i + LottoMatches.MIN_MATCH_COUNT;
                    int prize = LottoCalculator.PRIZES[matchedCountIndex];
                    sb.append(String.format("%d개 일치 (%d원) - %d개%n", matchedCountIndex, prize, count));
                });

        sb.append(String.format("총 수익률은 %.2f입니다.%n", profitRate));
        return sb.toString();
    }

}
