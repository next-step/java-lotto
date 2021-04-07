package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static List<Lotto> exchange(Money money) {
        return IntStream.range(0, money.purchase())
                .mapToObj(n -> new Lotto())
                .collect(Collectors.toList());
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Integer> match(WinningLotto winningLotto) {
        List<Integer> list = new ArrayList<>();
        for (Lotto lotto : lottos) {
            list.add(lotto.countMatch(winningLotto));
        }
        return list;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
