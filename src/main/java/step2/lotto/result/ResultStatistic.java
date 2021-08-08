package step2.lotto.result;

import step2.lotto.Lotto;
import step2.lotto.result.LottoResult;
import step2.lotto.result.LottoResults;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ResultStatistic {

    private final double totalRevenueRate;
    private final LottoResults lottoResults;

    public ResultStatistic(double totalRevenueRate, LottoResults lottoResults) {
        this.totalRevenueRate = totalRevenueRate;
        this.lottoResults = lottoResults;
    }

    public long countOfMatches(int countOfMatches) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.getCountOfMatches() == countOfMatches)
                .count();
    }

    public String getResult() {
        StringBuilder sb = new StringBuilder();
        createTitle(sb);
        createBody(sb);
        createFooter(sb);
        return sb.toString();
    }

    private void createTitle(StringBuilder sb) {
        sb.append("당첨 통계");
        sb.append("\n");
        sb.append("---------");
        sb.append("\n");
    }

    private void createBody(StringBuilder sb) {
        Map<Long, List<LottoResult>> groupByCountOfMatches = lottoResults.stream()
                .collect(groupingBy(LottoResult::getCountOfMatches));
        int countOfFourth = 0;
        if(groupByCountOfMatches.containsKey(Lotto.COUNT_OF_MATCHES_FOURTH))
            countOfFourth = groupByCountOfMatches.get(Lotto.COUNT_OF_MATCHES_FOURTH).size();
        int countOfThird = 0;
        if(groupByCountOfMatches.containsKey(Lotto.COUNT_OF_MATCHES_THIRD))
            countOfThird = groupByCountOfMatches.get(Lotto.COUNT_OF_MATCHES_THIRD).size();
        int countOfSecond = 0;
        if(groupByCountOfMatches.containsKey(Lotto.COUNT_OF_MATCHES_SECOND))
            countOfSecond = groupByCountOfMatches.get(Lotto.COUNT_OF_MATCHES_SECOND).size();
        int countOfFirst = 0;
        if(groupByCountOfMatches.containsKey(Lotto.COUNT_OF_MATCHES_FIRST))
            countOfFirst = groupByCountOfMatches.get(Lotto.COUNT_OF_MATCHES_FIRST).size();
        createBodyInternal(sb, countOfFourth, countOfThird, countOfSecond, countOfFirst);
    }

    private void createBodyInternal(StringBuilder sb, int countOfFourth, int countOfThird, int countOfSecond, int countOfFirst) {
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_FOURTH, Lotto.getLottoPrize(Lotto.COUNT_OF_MATCHES_FOURTH).getPrizeMoney(), countOfFourth));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_THIRD, Lotto.getLottoPrize(Lotto.COUNT_OF_MATCHES_THIRD).getPrizeMoney(), countOfThird));
        sb.append(String.format("%d개 일치 (%d원)- %d개\n", Lotto.COUNT_OF_MATCHES_SECOND, Lotto.getLottoPrize(Lotto.COUNT_OF_MATCHES_SECOND).getPrizeMoney(), countOfSecond));
        sb.append(String.format("%d개 일치 (%d원)- %d개", Lotto.COUNT_OF_MATCHES_FIRST, Lotto.getLottoPrize(Lotto.COUNT_OF_MATCHES_FIRST).getPrizeMoney(), countOfFirst));
        sb.append("\n");
    }

    private void createFooter(StringBuilder sb) {
        sb.append(String.format("총 수익률은 %.2f 입니다", totalRevenueRate));
    }
}
