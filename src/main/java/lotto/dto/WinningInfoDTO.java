package lotto.dto;

import lotto.domain.Amount;

import java.util.Objects;

public class WinningInfoDTO {
    private int correctCount;
    private Amount amount;

    public WinningInfoDTO(int correctCount, Amount amount) {
        this.correctCount = correctCount;
        this.amount = amount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinningAmount() {
        return amount.amount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfoDTO that = (WinningInfoDTO) o;
        return correctCount == that.correctCount && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, amount);
    }
}
