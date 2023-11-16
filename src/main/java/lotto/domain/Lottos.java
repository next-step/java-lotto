package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int ticketCount) {
        List<Lotto> lottos = LongStream.range(0, ticketCount)
                .mapToObj(i -> new Lotto(LottoNumberFactory.generateNumbers()))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public static Lottos of(List<List<Integer>> manualLottoNumbers) {
        List<Lotto> lottos = manualLottoNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public List<Lotto> sumLottos(Lottos otherLottos) {
        List<Lotto> allLottos = new ArrayList<>();
        allLottos.addAll(this.lottos);
        allLottos.addAll(otherLottos.getLottos());

        return Collections.unmodifiableList(allLottos);
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int countLottoSize() {
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
