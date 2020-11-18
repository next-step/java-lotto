package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;

    private LottoNumberParser lottoNumberParser = new LottoNumberParser();

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public WinningNumber(String expression) {
        parse(expression);
    }

    private void parse(String expression) {
        try {
            this.numbers = lottoNumberParser.parse(expression);
        } catch (RuntimeException e) {
            throw new InvalidWinningNumberException(expression, e.getCause() != null ? e.getCause() : e);
        }
    }

    public int getMatchedNumberCount(Lotto lotto) {
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