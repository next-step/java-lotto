package kr.insup.lotto.domain;

import kr.insup.lotto.utils.NumberGenerator;

import java.util.List;

public class Lotto {

    private List<String> numbers;

    public Lotto(NumberGenerator numberGenerator) {
        numbers = numberGenerator.generateNumber();
    }

    public Place matchWinningNumber(List<String> winningNumber) {
        int match = match(winningNumber);
        return Place.matchPlace(match);
    }

    private int match(List<String> winningNumber) {
        int match = 0;
        for (String number : winningNumber) {
            if (numbers.contains(number)) {
                match++;
            }
        }
        return match;
    }

    public List<String> numbers() {
        return numbers;
    }
}
