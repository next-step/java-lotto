package lotto.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void generateAuto(int count) {
        for (int i = 0; i < count; i++) {
            lottoList.add(Lotto.generateAuto());
        }
    }

    @Nonnull
    @Override
    public Iterator<Lotto> iterator() {
        return lottoList.iterator();
    }

    public int size() {
        return lottoList.size();
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

}
