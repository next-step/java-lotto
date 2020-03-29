package lotto.model.winninglotto;

import java.util.Collections;
import java.util.List;

public class WinningLottoNumbers {
    private List<Integer> winningLottoNumbers;

    public WinningLottoNumbers(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = Collections.unmodifiableList(winningLottoNumbers);
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
