package lotto.dto;

import lotto.domain.WinningAmount;

import java.util.Objects;

public class WinningInfoDTO {
    private int correctCount;
    private WinningAmount winningAmount;

    public WinningInfoDTO(int correctCount, WinningAmount winningAmount) {
        this.correctCount = correctCount;
        this.winningAmount = winningAmount;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public int getWinningAmount() {
        return winningAmount.amount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfoDTO that = (WinningInfoDTO) o;
        return correctCount == that.correctCount && Objects.equals(winningAmount, that.winningAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correctCount, winningAmount);
    }
}
