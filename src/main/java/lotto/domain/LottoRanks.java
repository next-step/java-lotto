package lotto.domain;

import java.util.List;

public class LottoRanks {

    private final List<LottoRank> lottoRanks;

    public LottoRanks(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public double totalReturnRate() {
        double totalWinAmount = totalWinAmount();
        double purchaseAmount = lottoRanks.size() * LottoTicket.PRICE;
        return Math.floor(totalWinAmount / purchaseAmount * 100) / 100;
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
}
