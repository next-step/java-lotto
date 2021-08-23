package step4.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public static Lottos empty() {
        return new Lottos();
    }

    private Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int price() {
        return Lotto.PRICE * lottos.size();
    }

    public int count() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void addAll(Lottos lottos) {
        List<Lotto> lottoList = lottos.stream()
                .collect(Collectors.toList());

        this.lottos.addAll(lottoList);
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
