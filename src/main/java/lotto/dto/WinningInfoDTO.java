package lotto.dto;

import lotto.domain.Amount;

import java.util.Objects;

public class WinningInfoDTO {
    private int correctCount;
    private int bonusCorrectCount;
    private Amount amount;

    public WinningInfoDTO(int correctCount, int bonusCorrectCount, Amount amount) {
        this.correctCount = correctCount;
        this.bonusCorrectCount = bonusCorrectCount;
        this.amount = amount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getBonusCorrectCount() {
        return bonusCorrectCount;
    }

    public Long getWinningAmount() {
        return amount.amount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfoDTO that = (WinningInfoDTO) o;
        return correctCount == that.correctCount && bonusCorrectCount == that.bonusCorrectCount && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, bonusCorrectCount, amount);
    }

    @Override
    public String toString() {
        return "WinningInfoDTO{" +
                "correctCount=" + correctCount +
                ", bonusCorrectCount=" + bonusCorrectCount +
                ", amount=" + amount +
                '}';
    }
}
