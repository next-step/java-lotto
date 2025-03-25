package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinnerNumberInput {
    private static final String DEFAULT_DELIMITER = ",";
    private final Lotto lotto;

    private WinnerNumberInput(Lotto lotto) {
        this.lotto = lotto;
    }

    public static WinnerNumberInput from(String input) {
        List<Integer> nums = convertStringToInt(input);
        Lotto lotto = Lotto.create(nums);
        return new WinnerNumberInput(lotto);
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    private static List<Integer> convertStringToInt(String input) {
        String[] splitInput = split(input);
        return Stream.of(splitInput)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String input) {
        return input.split(DEFAULT_DELIMITER);
    }
}
