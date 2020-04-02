package study.lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Lottos implements Iterable<Lotto> {
    List<Lotto> lottos;

    public static Lottos valueOf(Optional<Lottos> lottos) {
        return lottos.map(Lottos::new).orElseGet(Lottos::new);
    }

    // todo 이 생성자는 없애는 방향으로 리펙토링 하자
    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    // todo deep copy 가 아닌데 문제가 없을까?
    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(Lottos lottos) {
        this(lottos.lottos);
    }

    public int size() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    // todo get 과 set은 최소화 해야 한다.
    public Lotto get(int index) {
        return lottos.get(index);
    }

    @Override public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
