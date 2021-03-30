package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;

    private List<Integer> lottoNumbers = IntStream.rangeClosed(START_NUMBER, END_NUMBER).boxed().collect(Collectors.toList());
    private final List<Integer> lotto;


    public Lotto() {
        Collections.shuffle(lottoNumbers);
        lotto = lottoNumbers.stream()
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
                .filter(this.lotto::contains)
                .count();
        return Rank.valueOf(matchCount);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
