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
        BigDecimal totalWinAmount = new BigDecimal(totalWinAmount());
        BigDecimal purchaseAmount = new BigDecimal(purchaseAmount());
        BigDecimal totalReturnRate = totalWinAmount.divide(purchaseAmount, RETURN_RATE_SCALE, RoundingMode.FLOOR);
        return totalReturnRate.doubleValue();
    }

    private String totalWinAmount() {
        long totalWinAmount = lottoRanks.stream()
                .mapToLong(LottoRank::winAmount)
                .sum();
        return Long.toString(totalWinAmount);
    }

    private String purchaseAmount() {
        long purchaseAmount = (long) lottoRanks.size() * LottoTicket.PRICE;
        return Long.toString(purchaseAmount);
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
