package lotto.domain;

import java.util.List;

public class LottoResult {

    private final List<Prize> prizes;

    public LottoResult(List<Prize> prizes) {
        validateNotEmpty(prizes);
        this.prizes = List.copyOf(prizes);
    }

    private static void validateNotEmpty(List<Prize> prizes) {
        if (prizes.isEmpty()) {
            throw new RuntimeException("등수 목록이 비어 있습니다.");
        }
    }

    public int countOf(Prize prize) {
        return (int) prizes.stream()
                .filter(p -> p == prize)
                .count();
    }

    public long totalPrize() {
        return prizes.stream()
                .mapToLong(Prize::getMoney)
                .sum();
    }

    public double profitRate() {
        double profitRate = (double) totalPrize() / purchaseAmount();
        return Math.floor(profitRate * 100) / 100;
    }

    private int purchaseAmount() {
        return prizes.size() * Lotto.PRICE;
    }
}
