package lottery.domain;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

import java.util.Set;

public class WinningNumbers {

    private static final String SEPARATOR = ",";

    private static final String BLANK_REGEX = "\\s";

    private final Set<LotteryNumber> winningNumbers;

    public WinningNumbers(String source) {
        this(toWinningNumbers(source));
    }

    public WinningNumbers(Set<LotteryNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    private static Set<LotteryNumber> toWinningNumbers(String source) {
        return stream(separatedNumbers(source))
                .map(number -> new LotteryNumber(parseInt(number)))
                .collect(toSet());
    }

    private static String[] separatedNumbers(String source) {
        return removeBlank(source).split(SEPARATOR);
    }

    private static String removeBlank(String source) {
        return source.replaceAll(BLANK_REGEX, "");
    }

    public int size() {
        return winningNumbers.size();
    }
}
