package domain;

import strategy.PassivityLottoNumberGenerator;
import study.ValidateUtil;
import util.SplitUtil;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningNumbers, int bonusNumber) {
        Lotto numbers = getNumbers(winningNumbers, bonusNumber);
        return new WinningLotto(numbers, LottoNumber.valueOf(bonusNumber));
    }

    private static Lotto getNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> numbers = SplitUtil.splitToNumber(winningNumbers);
        ValidateUtil.validateLottoWinningNumber(numbers, bonusNumber);

        return Lotto.of(winningNumbers, new PassivityLottoNumberGenerator());
    }

    public Rank getRank(Lotto lotto) {
        Integer winningCount = lotto.getMatchCount(winningNumbers);
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.valueOf(winningCount, matchBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) &&
                Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusNumber);
    }
}
