package step2.view;

import step2.domain.*;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printNumOfLotto(int countOfLotto) {
        System.out.printf("%d개를 구매했습니다.%n", countOfLotto);
    }

    public static void printLottos(List<LottoNumber> lottos) {
        lottos.stream()
                .map(LottoNumber::getNumbers)
                .map(numbers -> numbers.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")))
                .forEach(numbers -> System.out.println("["+numbers+"]"));
    }

    public static String displayWinningStatistics(List<LottoNumber> lottos, LottoNumber winningNumbers, double profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n");
        sb.append("---------\n");

        LottoRankDTO matchCounts = LottoMatches.getMatchCounts(lottos, winningNumbers);
        sb.append(String.format("%d개 일치 (%d원) - %d개%n", LottoRank.FOURTH.getMatchCount(), LottoRank.FOURTH.getPrizeMoney(), matchCounts.getThreeMatchCount()));
        sb.append(String.format("%d개 일치 (%d원) - %d개%n", LottoRank.THIRD.getMatchCount(), LottoRank.THIRD.getPrizeMoney(), matchCounts.getFourMatchCount()));
        sb.append(String.format("%d개 일치 (%d원) - %d개%n", LottoRank.SECOND.getMatchCount(), LottoRank.SECOND.getPrizeMoney(), matchCounts.getFiveMatchCount()));
        sb.append(String.format("%d개 일치 (%d원) - %d개%n", LottoRank.FIRST.getMatchCount(), LottoRank.FIRST.getPrizeMoney(), matchCounts.getSixMatchCount()));
        sb.append(String.format("총 수익률은 %.2f입니다.", profitRate));
        if (profitRate < 1) {
            sb.append(" (기준이 1이기 때문에 결과적으로 손해입니다.)");
        }
        sb.append("\n");
        return sb.toString();
    }

}
