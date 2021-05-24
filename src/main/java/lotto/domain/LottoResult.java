package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {

    private final String DEFAULT_RANK_FORMAT = "%d개 일치 (%d원)- %d개%n";
    private final String SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원)- %d개%n";
    private final String RESULT_PROFIT_RATIO_FORMAT = "총 수익률은 %.2f입니다. (원금보전 시, 수익률이 1입니다)";
    private final int DEFAULT_COUNT = 0;

    private final TreeMap<Rank, Integer> lottoResult;
    private int purchaseAmount;
    private float profitRatio;

    public LottoResult(int purchaseAmount, WinningNumbers winningNumbers, List<LottoTicket> lottoTickets) {
        this.lottoResult = new TreeMap<>();
        this.purchaseAmount = purchaseAmount;
        setDefaultValues();
        updateLottoResult(winningNumbers, lottoTickets);
    }

    private void updateLottoResult(WinningNumbers winningNumbers, List<LottoTicket> lottoTickets) {
        for (LottoTicket ticket : lottoTickets) {
            Rank rank = ticket.rankBasedOn(winningNumbers);
            updateValue(rank);
        }
    }

    private void setDefaultValues() {
        for (Rank rank : Rank.values()) {
            lottoResult.put(rank, DEFAULT_COUNT);
        }
        lottoResult.remove(Rank.ELSE);
    }

    private void updateValue(Rank rank) {
        int resultCount = DEFAULT_COUNT;
        if (rank.equals(Rank.ELSE)) {
            return;
        }
        if (lottoResult.containsKey(rank)) {
            resultCount = lottoResult.get(rank);
        }
        lottoResult.put(rank, resultCount + 1);
    }

    public int getResultCount(Rank rank) {
        return lottoResult.get(rank);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            int rankCount = entry.getValue();
            if (rank.equals(Rank.SECOND)) {
                stringBuilder.append(String.format(SECOND_RANK_FORMAT, rank.getCountOfMatch(),
                        rank.getPrice(), rankCount));
                continue;
            }
            stringBuilder.append(String.format(DEFAULT_RANK_FORMAT, rank.getCountOfMatch(),
                    rank.getPrice(), rankCount));
        }
        this.profitRatio = calculateProfitRatio();
        stringBuilder.append(String.format(RESULT_PROFIT_RATIO_FORMAT, profitRatio));
        return stringBuilder.toString();
    }

    public float calculateProfitRatio() {
        long totalPrize = calculateTotalPrize();
        return totalPrize / (float) purchaseAmount;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            Rank rank = entry.getKey();
            int matchCount = entry.getValue();
            totalPrize += (long) rank.getPrice() * matchCount;
        }
        return totalPrize;
    }
}
