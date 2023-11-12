package lotto.domain;

import lotto.domain.strategy.LottoNumberStrategy;
import lotto.domain.strategy.ManualLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public Lottos(Lottos autoLottos,
                  Lottos manaulLottos) {
        List<Lotto> list = new ArrayList<>();
        list.addAll(manaulLottos.getAll());
        list.addAll(autoLottos.getAll());
        this.lottos = list;
    }

    public List<Lotto> getAll() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
