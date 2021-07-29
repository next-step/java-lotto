package lotto.domain.lotto;

import lotto.domain.money.Money;
import lotto.domain.prize.MatchResult;

import java.util.List;
import java.util.Objects;

public class LottoPackage {
    private final Lottos lottos;
    private final Money money;

    private LottoPackage(Lottos lottos, Money money) {
        validate(lottos, money);
        this.lottos = lottos;
        this.money = money;
    }

    private void validate(Lottos lottos, Money money) {
        if (Objects.isNull(lottos)) {
            throw new IllegalArgumentException("Lottos는 null이면 안됩니다");
        }

        if (Objects.isNull(money)) {
            throw new IllegalArgumentException("Money 값은 존재해야 합니다");
        }
    }

    public static LottoPackage of(Lottos lottos, Money money) {
        return new LottoPackage(lottos, money);
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public int getAllLottoCount() {
        return lottos.size();
    }

    public MatchResult match(WinningLotto winningLotto) {
        return MatchResult.of(lottos.calculateMatch(winningLotto), money);
    }

}
