package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Integer purchaseAmount, GetLottoNumbersStrategy getLottoNumbersStrategy) {
        int purchaseCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = new Lotto(getLottoNumbersStrategy);
            lottos.add(lotto);
        }
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Integer getPrize(WinningNumbers winningNumbers, Number bonus) {
        return lottos.stream()
                .mapToInt(lotto -> Prize.findPrize(lotto, winningNumbers, bonus).getPrize())
                .sum();
    }

    public Integer getCount(Prize prize, WinningNumbers winningNumbers, Number bonus) {
        if (prize == Prize.BONUS_SECOND) {
            Long count = lottos.stream()
                    .filter(lotto -> lotto.checkMatching(winningNumbers) == prize.getMatching() && lotto.checkContainNumber(bonus))
                    .count();
            return count.intValue();
        }
        if (prize == Prize.SECOND) {
            Long count = lottos.stream()
                    .filter(lotto -> lotto.checkMatching(winningNumbers) == prize.getMatching() && !lotto.checkContainNumber(bonus))
                    .count();
            return count.intValue();
        }
        Long count = lottos.stream()
                .filter(lotto -> lotto.checkMatching(winningNumbers) == prize.getMatching())
                .count();
        return count.intValue();
    }
}
