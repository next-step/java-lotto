package lotto.dto;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnounceWinning {

    private static final String REGEX_DELIMITER_DEFAULT = ",";

    private final Set<Integer> numbers;

    private AnnounceWinning(Set<Integer> winning) {
        this.numbers = winning;
    }

    public Set<Integer> getAnnounceWinning() {
        return this.numbers;
    }

    public static AnnounceWinning of(String input) {
        InputValidator.validateWinning(input);

        return new AnnounceWinning(Arrays.stream(input.split(REGEX_DELIMITER_DEFAULT))
                                   .map(Integer::parseInt)
                                   .collect(Collectors.toSet()));
    }
}
