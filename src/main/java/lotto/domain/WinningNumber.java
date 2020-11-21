package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;

    private WinningNumberParser parser = new WinningNumberParser();

    public WinningNumber(String numberString) {
        parse(numberString);
    }

    private void parse(String numberString) {
        try {
            this.numbers = parser.parse(numberString);
        } catch (LottoNumberParseException e) {
            throw new InvalidWinningNumberException(numberString, e);
        }
    }

    public long getMatchedNumberCount(Lotto lotto) {
        return lotto.getMatchedNumberCount(new WinningNumberMatcher(numbers));
    }
}

class WinningNumberMatcher implements NumberMatcher {

    private List<Integer> numbers;

    public WinningNumberMatcher(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean match(Integer number) {
        return this.numbers.contains(number);
    }
}