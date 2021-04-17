package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(Money money) {
        this.lottos = exchange(money);
    }

    private static List<Lotto> exchange(Money money) {
        return IntStream.range(0, money.purchase())
                .mapToObj(n -> new Lotto())
                .collect(Collectors.toList());
    }

    public static Lottos of(Money money) {
        return new Lottos(money);
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
        return Collections.unmodifiableList(lottos);
    }
}
