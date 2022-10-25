package lotto.strategy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoWinningGenerateStrategy implements LottoGenerateStrategy{

    private final String winningNumbersString;

    public LottoWinningGenerateStrategy(String winningNumbersString) {
        this.winningNumbersString = winningNumbersString;
    }

    @Override
    public Set<Integer> generateLotto() {
        String tempWinningNumbersString = winningNumbersString.replace(" ", "");
        String[] tempWinningNumbers = tempWinningNumbersString.split(",");
        return Arrays.stream(tempWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
    }
}
