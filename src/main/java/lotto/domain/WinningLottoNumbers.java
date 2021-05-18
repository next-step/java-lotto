package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoNumbers {
    private List<Integer> winningLottoNumbers;
    private int bonusNumber;

    public WinningLottoNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> winningLottoNumbers = new ArrayList<>();
        for (String element : winningNumbers.split(",| ,")) {
            winningLottoNumbers.add(Integer.valueOf(element));
        }
        this.winningLottoNumbers = winningLottoNumbers;

        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}
