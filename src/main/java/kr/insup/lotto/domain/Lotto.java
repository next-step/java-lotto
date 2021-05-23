package kr.insup.lotto.domain;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.utils.NumberGenerator;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private List<String> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        this(numberGenerator.generateNumber());
    }

    public Lotto(List<String> numbers) {
        validateLotto(numbers);
        this.numbers = numbers;
    }

    public void validateLotto(List<String> numbers) {

        if (isNumberWrongSize(numbers)) {
            throw new IllegalArgumentException();
        }

        if (isNumberDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }

        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private boolean isNumberWrongSize(List<String> numbers) {
        return numbers.size() != LottoConfig.PICK_NUMBER;
    }

    private boolean isNumberDuplicate(List<String> numbers) {
        return new HashSet<>(numbers).size() != LottoConfig.PICK_NUMBER;
    }

    private void validateNumber(String number) {
        if (!number.matches("\\d{1,2}") || LottoConfig.MIN_NUMBER > Integer.parseInt(number) || LottoConfig.MAX_NUMBER < Integer.parseInt(number)) {
            throw new IllegalArgumentException();
        }
    }

    public Place matchWinningNumber(Lotto winningNumber) {
        int match = match(winningNumber);
        return Place.matchPlace(match);
    }

    private int match(Lotto winningNumber) {
        int match = 0;
        for (String number : winningNumber.numbers()) {
            match = isWinningNumberContainNumber(number, match);
        }
        return match;
    }

    private int isWinningNumberContainNumber(String number, int match) {
        if (numbers.contains(number)) {
            match++;
        }
        return match;
    }

    public List<String> numbers() {
        return numbers;
    }
}
