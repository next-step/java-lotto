package lotto.domain;

import lotto.domain.strategy.ManualLottoNumberStrategy;
import lotto.domain.strategy.RandomLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoSeller {

    private LottoSeller() {
    }

    public static Lottos salesManualLottos(List<String> lottoNumbers) {
        return new Lottos(lottoNumbers.stream()
                .map(ManualLottoNumberStrategy::new)
                .map(ManualLottoNumberStrategy::create)
                .map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public static Lottos salesAutoLottos(RandomLottoNumberStrategy lottoNumberStrategy,
                                         int units) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < units; i++) {
            List<LottoNumber> numbers = lottoNumberStrategy.create();
            list.add(new Lotto(numbers));
        }
        return new Lottos(List.copyOf(list));
    }
}
