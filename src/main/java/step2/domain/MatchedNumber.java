package step2.domain;

import step2.exception.NotValidMatchedNumberCount;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class MatchedNumber {
    private static final String WINNING_DELIMITER = ", ";
    private static final int VALID_COUNT = 6;

    private Set<LottoNumber> matchedNumber;

    public MatchedNumber(String textNumber) {
        matchedNumber = Arrays.stream(textNumber.split(WINNING_DELIMITER))
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toSet());

        validCountOrElseThrow();
    }

    private void validCountOrElseThrow() {
        if (matchedNumber.size() < VALID_COUNT) {
            throw new NotValidMatchedNumberCount();
        }
    }
}
