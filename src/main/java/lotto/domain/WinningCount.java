package lotto.domain;

import java.util.List;

public class WinningCount {
    public static int compareNumbers(List<Integer> ticketNumbers, List<Integer> winningNumbers) {
        return (int) ticketNumbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }
}
