package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 22:53
 */
public class WinningLotto {

    private final Lotto winningLotto;

    private WinningLotto(String winningLotto) {
        this.winningLotto = Lotto.ofWinningLotto(winningLotto);
    }

    public static final WinningLotto of(String winningNumbers) {
        return new WinningLotto(winningNumbers);
    }

    public List<WinningLottoAmount> matchLottos(List<Lotto> userLotto) {
        List<WinningLottoAmount> winningLottoAmounts = new ArrayList<>();
        userLotto.forEach(lotto -> {
            winningLottoAmounts.add(WinningLottoAmount.findWinningAmount(winningLotto.match(lotto)));
        });
        return winningLottoAmounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}
