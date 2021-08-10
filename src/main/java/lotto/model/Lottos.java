package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private List<Lotto> lottos = new ArrayList<>();

    public int size() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
