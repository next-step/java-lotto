package step2.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {

    private static final String EXCEPTION_MESSAGE = "보너스 번호는 당첨번호와 중복될 수 없습니다";

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> input, int bonusNumber) {
        this.winningNumbers = input;
        this.bonusNumber = bonusNumber;
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return getBonusNumber() == that.getBonusNumber() && Objects.equals(getWinningNumbers(), that.getWinningNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningNumbers(), getBonusNumber());
    }
}
