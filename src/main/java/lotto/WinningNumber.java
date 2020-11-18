package lotto;

import java.util.List;

public class WinningNumber {

    private List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getMatchedNumberCount(Lotto lotto){
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