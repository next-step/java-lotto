package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int NUMBER_LENGTH = 6;
    private static final int BOUND_MAX = 45;
    private static final int BOUND_MIN = 1;
    private static final String CHECK_LENGTH = String.format("당첨 번호의 길이는 %d(이)여야 합니다.", NUMBER_LENGTH);
    private static final String CHECK_INTEGER = "당첨 번호는 모두 숫자여야 합니다.";
    private static final String CHECK_BOUND = String.format("당첨 번호는 %d ~ %d 범위의 값이어야 합니다.", BOUND_MIN, BOUND_MAX);
    private static final String CHECK_DUPLICATION = "중복되는 숫자가 포함되어 있는지 확인해주세요.";
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<String> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers.stream()
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    private void validate(List<String> winningNumbers) {
        checkLength(winningNumbers);
        checkInteger(winningNumbers);
        checkBound(winningNumbers);
        checkDuplication(winningNumbers);
    }

    public int countMatchingNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private void checkLength(List<String> winningNumbers) {
        if (winningNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_LENGTH);
        }
    }

    private void checkInteger(List<String> winningNumbers) {
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

    private void checkBound(List<
            String> winningNumbers) {
        for (String winningNumber : winningNumbers) {
            int number = Integer.parseInt(winningNumber);
            checkBound(number);
        }
    }

    private void checkBound(Integer number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
    }

    private void checkDuplication(List<String> winningNumbers) {
        long countAfterDeduplication = winningNumbers.stream()
                .distinct()
                .count();

        if (countAfterDeduplication != NUMBER_LENGTH) {
            throw new IllegalArgumentException(CHECK_DUPLICATION);
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
