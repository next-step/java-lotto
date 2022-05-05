package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos() {

    }

    public Lottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public void createLotto() {
        Lotto lotto = new Lotto();
        lottos.add(lotto);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
