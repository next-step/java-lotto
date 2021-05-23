package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

public class LottoRanks implements Iterable<LottoRank> {

    private static final int RETURN_RATE_SCALE = 2;

    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public double totalReturnRate() {
        BigDecimal totalWinAmount = BigDecimal.valueOf(totalWinAmount());
        BigDecimal purchaseAmount = BigDecimal.valueOf((long) lottoRanks.size() * LottoTicket.PRICE);
        BigDecimal totalReturnRate = totalWinAmount.divide(purchaseAmount, RETURN_RATE_SCALE, RoundingMode.FLOOR);
        return totalReturnRate.doubleValue();
    }

    private long totalWinAmount() {
        return lottoRanks.stream()
                .mapToLong(LottoRank::winAmount)
                .sum();
    }

    public int count(LottoRank rank) {
        return (int) lottoRanks.stream()
                .filter(lottoRank -> lottoRank == rank)
                .count();
    }

    @Override
    public Iterator<LottoRank> iterator() {
        return lottoRanks.iterator();
    }
}
