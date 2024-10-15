package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoResultBundle implements Iterable<Lotto> {
    private final List<Lotto> lottoBundle;

    public LottoResultBundle() {
        lottoBundle = new ArrayList<>();
    }

    public int size() {
        return lottoBundle.size();
    }

    public void add(final Lotto lotto) {
        lottoBundle.add(lotto);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottoBundle.iterator();
    }
}
