package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
