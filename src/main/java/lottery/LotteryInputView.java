package lottery;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LotteryInputView {
    public LotteryRow toLotteryRow(String input) {
        checkNotEmpty(input);
        var numbers = Arrays.stream(input.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return LotteryRow.fromGiven(numbers);
    }

    public Natural toNatural(String input) {
        checkNotEmpty(input);
        return new Natural(parseToInt(input));
    }

    public LotteryNumber toLotteryNumber(String input) {
        checkNotEmpty(input);
        return LotteryNumber.fromGiven(parseToInt(input));
    }

    private int parseToInt(String input) {
        checkIsNumeric(input);
        return Integer.parseInt(input);
    }

    private void checkNotEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("Input is empty");
        }
    }

    private void checkIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("Input is not a non-negative integer");
        }
    }
}
