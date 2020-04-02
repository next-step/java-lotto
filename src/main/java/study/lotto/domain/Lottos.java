package study.lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    List<Lotto> lottos;

    // todo 이 생성자는 없애는 방향으로 리펙토링 하자
    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(Lottos lottos) {
        this(lottos.lottos);
    }

    public int size() {
        return lottos.size();
    }

    @Override public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
