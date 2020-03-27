package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class LottoGameResults {
    private final Map<Integer, Integer> lottoGameResults;

    LottoGameResults(LottoNumbers boughtNumbers, LottoNumber winningNumber) {
        this.lottoGameResults = checkWinning(boughtNumbers, winningNumber);
    }

    private Map<Integer, Integer> checkWinning(LottoNumbers boughtNumbers, LottoNumber winningNumber) {
        List<Long> gameResults = boughtNumbers.checkWinningNumber(winningNumber);
        return gameResults.stream()
                .collect(groupingBy(e -> e.intValue(), HashMap::new, summingInt(e -> e.intValue())));
    }

}
