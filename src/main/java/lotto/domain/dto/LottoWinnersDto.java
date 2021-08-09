package lotto.domain.dto;

import lotto.domain.Award;

public class LottoWinnersDto {
    private int amount;
    private int matchNumbers;
    private long countWinners;

    public LottoWinnersDto(Award award, long countWinners) {
        this.amount = award.getAmount();
        this.matchNumbers = award.getMatchNumbers();
        this.countWinners = countWinners;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchNumbers() {
        return matchNumbers;
    }

    public long getCountWinners() {
        return countWinners;
    }
}
