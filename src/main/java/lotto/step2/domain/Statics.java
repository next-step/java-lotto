package lotto.step2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Statics {

    private static final String COMMA = ",";

    private Lotto winningNumbers;
    private Lotteries lotteries;

    public Statics(String winningNumbers) {
        setWinningNumbers(winningNumbers);
    }

    public Statics(String winningNumbers, Lotteries lotteries) {
        this(winningNumbers);
        this.lotteries = lotteries;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int totalCountOfMatch(int expected) {
        return lotteries.totalCountOfMatch(winningNumbers, expected);
    }

    private void setWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(COMMA))
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
        this.winningNumbers = new Lotto(winningNumbers);
    }

}
