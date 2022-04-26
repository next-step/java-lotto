package autolotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static autolotto.LottoExceptionCode.*;

public class WinningLotto {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5]");
    private static final String DELIMITER = ",";
    private static final int NUMBER_COUNT = 6;
    private final Set<Integer> winningNumbers = new HashSet<>();

    public WinningLotto(String winningNumber) {
        List<String> splitNumbers = Arrays.stream(winningNumber.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());

        if (splitNumbers.size() < NUMBER_COUNT) {
            throw new LottoException(INVALID_WINNING_NUMBER_COUNT);
        }

        boolean isValid = splitNumbers.stream()
                .allMatch(number -> NUMBER_PATTERN.matcher(number).matches());

        if (!isValid) {
            throw new LottoException(INVALID_WINNING_NUMBER_TYPE);
        }

        splitNumbers.stream().mapToInt(Integer::parseInt).forEach(winningNumbers::add);

        if (winningNumbers.size() < NUMBER_COUNT) {
            throw new LottoException(DUPLICATED_WINNING_NUMBER);
        }
    }
}
