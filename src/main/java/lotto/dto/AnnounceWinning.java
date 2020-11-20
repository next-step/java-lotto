package lotto.dto;

import lotto.validator.InputValidator;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnounceWinning {

    private static final String REGEX_DELIMITER_DEFAULT = ",";

    private final Set<Integer> numbers;
    private final int bonusNumber;

    private AnnounceWinning(Set<Integer> winning, int bonusNumber) {
        this.numbers = winning;
        this.bonusNumber = bonusNumber;
    }

    public static AnnounceWinning of(String input, String bonus) {
        InputValidator.validateWinning(input, bonus);

        return new AnnounceWinning(Arrays.stream(input.split(REGEX_DELIMITER_DEFAULT))
                                           .map(Integer::parseInt)
                                           .collect(Collectors.toSet()), Integer.parseInt(bonus));
    }

    public Set<Integer> getAnnounceWinning() {
        return this.numbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
