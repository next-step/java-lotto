package lotto.domain;

import java.util.Objects;

public class WinningNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final String CHECK_LENGTH = String.format("로또 번호의 길이는 {}(이)여야 합니다.", NUMBER_LENGTH);
    private final String[] winningNumbers;

    public WinningNumbers(String[] winningNumbers) {
        checkLength(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void checkLength(String[] winningNumbers) {
        if (winningNumbers.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_LENGTH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
