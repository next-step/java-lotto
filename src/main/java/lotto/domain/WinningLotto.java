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

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();
    private final Lotto winningLotto;
    private final LottoNumber bonusNo;

    private WinningLotto(String winningLotto) {
        this(winningLotto, 0);
    }

    public WinningLotto(String winningNumbers, int bonusNo) {
        this.winningLotto = Lotto.ofWinningLotto(winningNumbers);
        this.bonusNo = createBonusNo(bonusNo);
    }

    public static final WinningLotto of(String winningNumbers) {
        return new WinningLotto(winningNumbers);
    }

    public List<WinningLottoAmount> matchLottos(List<Lotto> userLotto) {
        List<WinningLottoAmount> winningLottoAmounts = new ArrayList<>();
        userLotto.forEach(lotto -> {
            winningLottoAmounts.add(WinningLottoAmount.findWinningAmount(winningLotto.match(lotto), lotto.matchBonusNo(bonusNo)));
        });
        return winningLottoAmounts;
    }

    private LottoNumber createBonusNo(int bonusNo) {
        if (bonusNo == 0) {
            return LottoNumber.of(LOTTO_GENERATOR.generateBonusNo(this.winningLotto));
        }

        return LottoNumber.of(bonusNo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusNo, that.bonusNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNo);
    }
}
