package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        this.lottos = createLottos(numberOfLotto, lottoCreatingStrategy);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(int numberOfLotto, LottoCreatingStrategy lottoCreatingStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < numberOfLotto; i++ ){
            lottos.add(create(lottoCreatingStrategy));
        }
        return lottos;
    }

    private Lotto create(LottoCreatingStrategy lottoCreatingStrategy) {
        return lottoCreatingStrategy.create();
    }

    public List<Integer> matchesLottos(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.matchesNumber(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
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
