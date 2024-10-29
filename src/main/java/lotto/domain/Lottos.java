package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public List<Rank> matchAll(WinningLotto winningLotto) {
        List<Rank> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(winningLotto.match(lotto));
        }
        return result;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
