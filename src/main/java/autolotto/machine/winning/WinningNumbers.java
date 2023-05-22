package autolotto.machine.winning;

import autolotto.machine.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    public List<LottoNumber> winningNumbers() {
        return new ArrayList<>(this.winningNumbers);
    }
}
