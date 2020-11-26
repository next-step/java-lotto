package lotto.domain;

import java.util.List;

public class WinningNumber {

    private BonusNumber bonusNumber;
    private List<Integer> numbers;

    private LottoNumberParser parser = new LottoNumberParser();

    public WinningNumber(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = getBonusNumberIfValid(bonusNumber);
    }

    public WinningNumber(String winningNumberExp, int bonusNumber) {
        parse(winningNumberExp);
        this.bonusNumber = getBonusNumberIfValid(bonusNumber);
    }

    private BonusNumber getBonusNumberIfValid(int bonusNumber) {
        if (numbers.contains(bonusNumber)) throw new InvalidBonusNumberException(bonusNumber);
        return new BonusNumber(bonusNumber);
    }

    private void parse(String numberString) {
        try {
            this.numbers = parser.parse(numberString);
        } catch (LottoNumberParseException e) {
            throw new InvalidWinningNumberException(numberString, e);
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
        return bonusNumber.getNumberMatcher();
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