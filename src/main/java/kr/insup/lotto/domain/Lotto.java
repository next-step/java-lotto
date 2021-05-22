package kr.insup.lotto.domain;

import kr.insup.lotto.utils.NumberGeneratingStrategy;

import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(NumberGeneratingStrategy numberGeneratingStrategy) {
        numbers = numberGeneratingStrategy.generateNumber();
    }

    public Place matchWinningNumber(List<Integer> winningNumber) {
        int match = match(winningNumber);
        return Place.matchPlace(match);
    }

    private int match(List<Integer> winningNumber) {
        int match = 0;
        for (int number : winningNumber) {
            if (numbers.contains(number)) {
                match++;
            }
        }
        return match;
    }
}
