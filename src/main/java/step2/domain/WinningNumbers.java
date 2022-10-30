package step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningNumbers {

    private static final String SEPARATOR = ",";
    private static final String EXCEPTION_MESSAGE = "숫자와 콤마만 입력해 주세요";

    private final List<Integer> winningNumbers;

    public WinningNumbers(String input) {
        this.winningNumbers = createWinningNumbers(input);
    }

    private List<Integer> createWinningNumbers(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(this::parseInteger)
                .collect(Collectors.toList());
    }

    private int parseInteger(String index) {
        try {
            return Integer.parseInt(index);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(getWinningNumbers(), that.getWinningNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningNumbers());
    }
}
