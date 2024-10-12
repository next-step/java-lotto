package lotto.dto;

import java.util.List;
import java.util.Objects;

public class WinningNumbersDTO {
    private final List<Integer> winningNumbers;

    private WinningNumbersDTO(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbersDTO valueOf(List<Integer> winningNumbers) {
        return new WinningNumbersDTO(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbersDTO that = (WinningNumbersDTO) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(winningNumbers);
    }
}
