package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;
import lotto.domain.strategy.ManualLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(LottoNumberStrategy lottoNumberStrategy,
                  int count) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<LottoNumber> numbers = lottoNumberStrategy.create();
            list.add(new Lotto(numbers));
        }
        this.lottos = List.copyOf(list);
    }

    public Lottos(List<String> lottoNumbers) {
        this.lottos = lottoNumbers.stream()
                .map(ManualLottoNumberStrategy::new)
                .map(ManualLottoNumberStrategy::create)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public Lottos(Lottos lottos,
                  Lottos manaulLottos) {
        List<Lotto> list = new ArrayList<>();
        list.addAll(manaulLottos.getAll());
        list.addAll(lottos.getAll());
        this.lottos = list;
    }

    public List<Lotto> getAll() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
    }
}
