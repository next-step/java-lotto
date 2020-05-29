package lotto.domain.winning;

import lotto.domain.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final LottoNumbers winningLottoNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningLottoNumbers = createWinningNumbers(winningNumbers);
    }

    private LottoNumbers createWinningNumbers(String winningNumberString) {
        List<Integer> winningNumbers = Arrays.stream(winningNumberString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new LottoNumbers(winningNumbers);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
