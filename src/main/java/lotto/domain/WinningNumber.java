package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningNumber {

    private final int bonusNumber;
    private List<Integer> numbers;

    private WinningNumberParser parser = new WinningNumberParser();

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = getBonusNumberIfValid(bonusNumber);
    }

    public WinningNumber(String winningNumberExp, int bonusNumber) {
        parse(winningNumberExp);
        this.bonusNumber = getBonusNumberIfValid(bonusNumber);
    }

    private int getBonusNumberIfValid(int bonusNumber) {
        if (numbers.contains(bonusNumber)) throw new InvalidBonusNumberException(bonusNumber);
        if (bonusNumber < 1 || bonusNumber > 45) throw new InvalidBonusNumberException(bonusNumber);
        return bonusNumber;
    }

    private void parse(String expression) {
        try {
            numbers = parser.parse(expression);
        } catch (RuntimeException e) {
            throw new InvalidWinningNumberException(expression, e.getCause() != null ? e.getCause() : e);
        }
    }

    public long getMatchedWinningNumberCount(Lotto lotto) {
        return lotto.getMatchedNumberCount(winningNumberMatcher());
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getMatchedNumberCount(bonusNumberMatcher()) == 1;
    }

    private NumberMatcher winningNumberMatcher() {
        return new ListNumberMatcher(numbers);
    }

    private NumberMatcher bonusNumberMatcher() {
        return new ListNumberMatcher(Arrays.asList(bonusNumber));
    }
}

class ListNumberMatcher implements NumberMatcher {

    private List<Integer> numbers;

    public ListNumberMatcher(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean match(Integer number) {
        return numbers.contains(number);
    }
}