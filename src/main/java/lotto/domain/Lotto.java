package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> rangeNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private final List<Integer> lotto;


    public Lotto() {
        Collections.shuffle(rangeNumbers);
        lotto = rangeNumbers.stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toList());
    }

    public Lotto(List<Integer> randomNumbers) {
        lotto = randomNumbers;
    }

    public Rank winningResult(WinningNumber winningNumber) {
        int matchCount = (int) winningNumber.getWinningNumbers()
                .stream()
                .filter(number -> this.lotto.contains(number))
                .count();
        return Rank.valueOf(matchCount);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
