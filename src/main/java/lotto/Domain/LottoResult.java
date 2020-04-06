package lotto.Domain;


import java.util.*;

public class LottoResult {

    private SortedMap<LottoGrade, Integer> statistics;

    private LottoResult() {
        statistics = new TreeMap<>();
        Arrays.stream(LottoGrade.values()).forEach(value -> {
            statistics.put(value, 0);
        });
    }

    public static LottoResult init() {
        return new LottoResult();
    }

    public void addWinGrade(LottoGrade lottoGrade) {
        statistics.put(lottoGrade, statistics.get(lottoGrade) + 1);
    }

    public double revenueRate() {
        double sumOfWinningLotto = 0.0;

        for (Map.Entry<LottoGrade, Integer> entry : statistics.entrySet()) {
            sumOfWinningLotto += calculatePrize(entry);
        }

        return sumOfWinningLotto / (this.size() * 1000.0);
    }

    int calculatePrize(Map.Entry<LottoGrade, Integer> entry) {
        if(entry.getKey().getPrize() <= 2) {
            return 0;
        }
        return entry.getKey().getPrize() * entry.getValue();
    }

    private int size() {
        int size = 0;

        for (Map.Entry<LottoGrade, Integer> entry : statistics.entrySet()) {
            size += entry.getValue();
        }
        return size;
    }

    public Map<LottoGrade, Integer> winLottoGradeAndPrize() {
        return Collections.unmodifiableSortedMap(statistics);
    }
}
