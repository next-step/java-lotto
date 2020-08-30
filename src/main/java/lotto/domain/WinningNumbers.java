package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;

    public WinningNumbers(String[] winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers)
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());
    }
    
    public long findSameNumber(List<Integer> lotto) {
        return lotto.stream()
                .filter(n -> winningNumbers.contains(n))
                .count();
    }
}
