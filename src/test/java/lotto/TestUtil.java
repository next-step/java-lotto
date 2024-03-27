package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.view.InputView.COMMA_BLANK_DELIMITER;

public class TestUtil {
    private TestUtil() {
    }

    public static List<Integer> numbersForTest(String winningNumbersInput) {
        return Arrays.stream(winningNumbersInput.split(COMMA_BLANK_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
