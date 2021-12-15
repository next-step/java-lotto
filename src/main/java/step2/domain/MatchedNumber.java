package step2.domain;

import step2.exception.DuplicatedNumberException;
import step2.exception.NotValidNumberCountException;

import java.util.*;
import java.util.stream.Collectors;

public class MatchedNumber {
    private static final String WINNING_DELIMITER = ", ";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int VALID_COUNT = 6;

    private List<LottoNumber> matchedNumber;

    public MatchedNumber(String textNumber) {
        this.matchedNumber = Arrays.stream(textNumber.split(WINNING_DELIMITER))
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());

        validateMatchedNumber();
    }

   /* public List<LottoNumber> getMatchedNumbers() {
        return Collections.unmodifiableList(this.matchedNumber);
    }*/

    public boolean matchedNumber(LottoNumber number) {
        return this.matchedNumber.contains(number);
    }

    private void validateMatchedNumber() {
        long duplicatedCount = this.matchedNumber.stream()
                .filter(number -> Collections.frequency(this.matchedNumber, number) > ONE)
                .count();

        if (duplicatedCount != ZERO) {
            throw new DuplicatedNumberException();
        }

        if (this.matchedNumber.size() != VALID_COUNT) {
            throw new NotValidNumberCountException();
        }
    }

}
