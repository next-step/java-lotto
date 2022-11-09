package lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultStat {
    private final Map<LottoResult, Integer> resultMap;

    public LottoResultStat(List<LottoResult> results) {
        this.resultMap = results.stream()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public int getWinnerCount(LottoResult result) {
        return resultMap.getOrDefault(result, 0);
    }

    public double getProfitMargin(int lottoPrice) {
        double sum = 0.0;
        for (LottoResult result : LottoResult.values()) {
            sum += result.getPrize() * getWinnerCount(result);
        }
        return sum / ((long) lottoPrice * totalTicketCount());
    }

    private int totalTicketCount() {
        int count = 0;
        for (LottoResult key : resultMap.keySet()) {
            count += resultMap.get(key);
        }
        return count;
    }
}
