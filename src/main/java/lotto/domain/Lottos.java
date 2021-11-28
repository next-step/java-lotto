package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos ofStrategy(Integer purchaseCount, GetLottoNumbersStrategy getLottoNumbersStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.ofStrategy(getLottoNumbersStrategy);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static Lottos ofLottoList(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getPrize(WinningLotto winningLotto, LottoNumber bonus) {
        return lottos.stream()
                .mapToInt(lotto -> Prize.findPrize(lotto.checkMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus)).getPrize())
                .sum();
    }

    public Integer getCount(Prize prize, WinningLotto winningLotto, LottoNumber bonus) {
        Long count = lottos.stream()
                .filter(lotto -> Prize.findPrize(lotto.checkMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus)) == prize)
                .count();
        return count.intValue();
    }

    public void mergeLottos(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
    }


}
