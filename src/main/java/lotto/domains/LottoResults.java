package lotto.domains;

import java.util.*;

public class LottoResults {

    private static final int WINNING_LIMIT = 3;

    private final List<LottoResult> lottoResults;

    public LottoResults() {
        Map<Integer, Integer> winningInfos = winningPrizeInfo();

        List<LottoResult> lottoResults = new ArrayList<>();
        for (Integer key : winningInfos.keySet()) {
            lottoResults.add(new LottoResult(key, winningInfos.get(key)));
        }

        this.lottoResults = lottoResults;
    }

    private Map<Integer, Integer> winningPrizeInfo() {
        Map<Integer, Integer> winningInfos = new HashMap<>();

        winningInfos.put(3, 5000);
        winningInfos.put(4, 50000);
        winningInfos.put(5, 1500000);
        winningInfos.put(6, 2000000000);

        return winningInfos;
    }

    public void addWinner(int matchCnt) {
        if (matchCnt < WINNING_LIMIT) {
            return;
        }

        lottoResults.forEach(lottoResult -> lottoResult.addWinner(matchCnt));
    }

    public List<LottoResult> getLottoResults() {
        return this.lottoResults;
    }

    public Double profitRate(int money) {
        double totalPrize = lottoResults.stream()
                .mapToDouble(LottoResult::prizeSum)
                .sum();

        double profitRate = totalPrize / money;
        return Math.round(profitRate * 100) / 100.0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResults that = (LottoResults) o;
        return Objects.equals(getLottoResults(), that.getLottoResults());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottoResults());
    }
}
