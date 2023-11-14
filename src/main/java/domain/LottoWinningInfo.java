package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningInfo {

    private List<Integer> winnerNumbers;

    public LottoWinningInfo(List<String> numbers) {
        this.winnerNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
