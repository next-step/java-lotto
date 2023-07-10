package lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복 됩니다.");
        }
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }
}
