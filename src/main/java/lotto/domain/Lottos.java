package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    private Lottos(Money money) {
        this.lottos = exchange(money);
    }

    public static Lottos of(Money money) {
        return new Lottos(money);
    }

    private List<Lotto> exchange(Money money) {
        return IntStream.range(0, money.purchaseAuto())
                .mapToObj(n -> new Lotto())
                .collect(Collectors.toList());
    }

    public void addLottoList(List<Lotto> lottoList) {
        lottoList.forEach(this::addLotto);
    }

    private void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public int size() {
        return lottos.size();
    }

    public List<Hit> matchHit(WinningLotto winningLotto) {
        List<Hit> hitList = new ArrayList<>();
        for (Lotto lotto : lottos) {
            hitList.add(new Hit(lotto.countMatch(winningLotto), lotto.containsBonus(winningLotto)));
        }
        return hitList;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
