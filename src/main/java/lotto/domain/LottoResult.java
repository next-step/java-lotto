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
    private static final int INIT_BONUS_NO = 0;
    private final WinningLotto winningLotto;

    private LottoResult(String winningLotto) {
        this(winningLotto, INIT_BONUS_NO);
    }

    private LottoResult(String winningLotto, int bonusNo) {
        this.winningLotto = WinningLotto.ofBonusNo(winningLotto, bonusNo);
    }

    public static final LottoResult of(String winningLotto) {
        return new LottoResult(winningLotto);
    }

    public static final LottoResult ofBonusNo(String winningLotto, int bonusNo) {
        return new LottoResult(winningLotto, bonusNo);
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
