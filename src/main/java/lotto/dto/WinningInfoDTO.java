package lotto.dto;

import lotto.domain.Amount;

import java.util.Objects;

public class WinningInfoDTO {
    private int correctCount;
    private boolean bonusCorrect;
    private Amount amount;

    public WinningInfoDTO(int correctCount, boolean bonusCorrect, Amount amount) {
        this.correctCount = correctCount;
        this.bonusCorrect = bonusCorrect;
        this.amount = amount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public boolean getBonusCorrect() {
        return bonusCorrect;
    }

    public Long getWinningAmount() {
        return amount.amount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfoDTO that = (WinningInfoDTO) o;
        return correctCount == that.correctCount && bonusCorrect == that.bonusCorrect && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, bonusCorrect, amount);
    }

    @Override
    public String toString() {
        return "WinningInfoDTO{" +
                "correctCount=" + correctCount +
                ", bonusCorrectCount=" + bonusCorrect +
                ", amount=" + amount +
                '}';
    }
}
