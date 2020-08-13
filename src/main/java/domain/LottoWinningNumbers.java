package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int getWinningNumberInLottoGame(LottoNumbers lottoGame) {
        List<Integer> collect = lottoGame.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());
        return collect.size();
    }
}
