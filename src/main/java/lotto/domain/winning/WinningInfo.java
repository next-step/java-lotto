package lotto.domain.winning;

import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class WinningInfo {

    private final int count;

    private final boolean hasBonus;

    public WinningInfo(Lotto lotto, WinningNumbers winningNumbers) {
        this.count = getCount(lotto, winningNumbers.getWinningNumbers());
        this.hasBonus = hasBonus(lotto, winningNumbers.getBonusNumber());
    }

    private int getCount(Lotto lotto, List<LottoNumber> winningNumbers) {
        int count = 0;
        for (LottoNumber winningNumber : winningNumbers) {
            if (lotto.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasBonus(Lotto lotto, LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    public int getCount() {
        return count;
    }

    public boolean getHasBonus() {
        return hasBonus;
    }
}
