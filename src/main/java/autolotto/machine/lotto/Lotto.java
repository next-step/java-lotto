package autolotto.machine.lotto;

import autolotto.machine.winning.WinningNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public int matchCount(WinningNumbers comparisonTarget) {
        ArrayList<Integer> winningNumbers = new ArrayList<>(comparisonTarget.winningNumbers());
        Collections.sort(winningNumbers);

        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public int size() {
        return this.numbers.size();
    }

    public List<Integer> lottoNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
