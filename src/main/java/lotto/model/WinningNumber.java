package lotto.model;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class WinningNumber {
    private static final String DELIMITER = ", ";
    private static final int NUMBER_OF_LOTTO_COUNT = 6;

    private final List<Integer> winningNumber;

    private WinningNumber(final List<Integer> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public static WinningNumber from(final String winningNumber) {
        Objects.requireNonNull(winningNumber, "winningNumbers must be not null.");
        return new WinningNumber(parseIntegerList(winningNumber));
    }

    private static List<Integer> parseIntegerList(final String winningNumber) {
        return stream(winningNumber.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(toList());
    }

    public boolean isSizeValid() {
        return winningNumber.size() == NUMBER_OF_LOTTO_COUNT;
    }

    public List<Integer> read() {
        return List.copyOf(winningNumber);
    }
}
