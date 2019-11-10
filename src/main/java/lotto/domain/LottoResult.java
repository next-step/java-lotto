package lotto.domain;

import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-10 01:17
 */
public class LottoResult {

    private static final int LOTTO_PRICE = 1000;
    private final WinningLotto winningLotto;

    public LottoResult(String winningLotto) {
        this.winningLotto = WinningLotto.of(winningLotto);
    }

    public List<WinningLottoAmount> getWinningLottoAmount(List<Lotto> userLotto) {
        return winningLotto.matchLottos(userLotto);
    }

    public double rateOfReturn(List<Lotto> userLotto) {
        long totalAmount = WinningLottoAmount.totalAmount(getWinningLottoAmount(userLotto));
        return totalAmount / (double) (userLotto.size() * LOTTO_PRICE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}
