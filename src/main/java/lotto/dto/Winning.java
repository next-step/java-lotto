package lotto.dto;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Winning {

    private static final String REGEX_DELIMITER_DEFAULT = ",";

    private final Set<Integer> numbers;

    private Winning(Set<Integer> winning) {
        this.numbers = winning;
    }

    public Set<Integer> getWinning() {
        return this.numbers;
    }

    public static Winning of(String input) {
        InputValidator.validateWinning(input);

        return new Winning(Arrays.stream(input.split(REGEX_DELIMITER_DEFAULT))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toSet()));
    }
}
