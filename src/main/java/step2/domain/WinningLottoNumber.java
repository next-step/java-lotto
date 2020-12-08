package step2.domain;

import java.util.*;

public class WinningLottoNumber {
    private final List<LottoNo> winningNumbers = new ArrayList<>();
    private BonusNumber bonusNumber;

    public WinningLottoNumber(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            this.winningNumbers.add(LottoNo.create(winningNumber));
        }
        numberValid();
    }

    private void numberValid() {
        if (isNotMatchNumberCount()) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
    }

    private boolean isNotMatchNumberCount() {
        return this.winningNumbers.size() != LottoConstant.NEED_COUNT;
    }

    public List<LottoNo> getNumbers() {
        return this.winningNumbers;
    }

    public long findIsMatchNumberCount(Lotto lotto) {
        return this.winningNumbers.stream()
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

        this.bonusNumber = BonusNumber.getInstance(bonusNumber);
    }

    private boolean isContainsWinningNumber(LottoNo bonusNumber) {
        return this.winningNumbers.contains(bonusNumber);
    }

    public int getBonusNumber() {
        return this.bonusNumber.getNumber();
    }
}
