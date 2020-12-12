package step2.domain;

import java.util.*;

public class WinningLottoNumber {
    private final Lotto winningNumbers;
    private LottoNo bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumbers) {
        this.winningNumbers = Lotto.create(winningNumbers);
    }

    public List<LottoNo> getNumbers() {
        return this.winningNumbers.getNumbers();
    }

    public long findIsMatchNumberCount(Lotto lotto) {
        return this.winningNumbers.getNumbers().stream()
                .filter(winNumber -> isContains(winNumber, lotto))
                .count();
    }

    private boolean isContains(LottoNo winNumber, Lotto lotto) {
        return lotto.isContains(winNumber);
    }

    public void addBonusNumber(int bonusNumber) {
        LottoNo bonusLottoNo = LottoNo.create(bonusNumber);
        if (isContainsWinningNumber(bonusLottoNo)) {
            throw new IllegalArgumentException("당첨번호와 겹치지 않는 숫자를 입력하세요.");
        }

        this.bonusNumber = LottoNo.create(bonusNumber);
    }

    private boolean isContainsWinningNumber(LottoNo bonusNumber) {
        return this.winningNumbers.getNumbers().contains(bonusNumber);
    }

    public LottoNo getBonusNumber() {
        return this.bonusNumber;
    }
}
