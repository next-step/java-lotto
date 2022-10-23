package lotto.core;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningGenerateStrategy implements LottoGenerateStrategy{

    private final String winningNumbersString;

    public LottoWinningGenerateStrategy(String winningNumbersString) {
        this.winningNumbersString = winningNumbersString;
    }

    @Override
    public List<Integer> generateLotto() {
        String tempWinningNumbersString = winningNumbersString.replace(" ", "");
        String[] tempWinningNumbers = tempWinningNumbersString.split(",");
        return Arrays.stream(tempWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
