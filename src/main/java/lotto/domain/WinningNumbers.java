package lotto.domain;

import java.util.Objects;

public class WinningNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final String CHECK_LENGTH = String.format("당첨 번호의 길이는 {}(이)여야 합니다.", NUMBER_LENGTH);
    private static final String CHECK_INTEGER = "당첨 번호는 모두 숫자여야 합니다.";
    private final String[] winningNumbers;

    public WinningNumbers(String[] winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(String[] winningNumbers) {
        checkLength(winningNumbers);
        checkInteger(winningNumbers);
    }

    private void checkLength(String[] winningNumbers) {
        if (winningNumbers.length != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_LENGTH);
        }
    }

    private void checkInteger(String[] winningNumbers) {
        for (String winningNumber : winningNumbers) {
            checkInteger(winningNumber);
        }
    }

    private void checkInteger(String winningNumber) {
        try {
            Integer.parseInt(winningNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CHECK_INTEGER);
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
