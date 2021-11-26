package lotto.domain;

import lotto.domain.starategy.GetLottoNumbersStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createRandomLottos(Integer purchaseAmount, GetLottoNumbersStrategy getLottoNumbersStrategy) {
        int purchaseCount = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            Lotto lotto = Lotto.createRandomLotto(getLottoNumbersStrategy);
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static Lottos createManualLottos(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

//    public static Lottos createManualLottos(List<String> lottos) {
//        return new Lottos(lottos.stream().map(lottoString -> Lotto.createManualLotto(lottoString)).collect(Collectors.toList()));
//    }

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
}
