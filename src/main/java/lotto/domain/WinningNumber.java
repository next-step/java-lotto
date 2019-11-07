package lotto.domain;

import java.util.*;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-07 14:49
 */
public class WinningNumber {

    private final List<Integer> winningNumbers;

    public WinningNumber(Integer... winningNumbers) {
        this(Arrays.asList(winningNumbers));
    }

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<LottoWinningAmount> getWinningAmount(List<Lotto> purchasedLotto) {
        List<LottoWinningAmount> winningAmounts = new ArrayList<>();
        purchasedLotto.forEach(lotto -> {
            winningAmounts.add(LottoWinningAmount.findWinningAmount(lotto.matchLottoNumberCount(this.winningNumbers)));
        });

        return Collections.unmodifiableList(winningAmounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
