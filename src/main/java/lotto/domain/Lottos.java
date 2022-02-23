package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> get() {
        return lottos;
    }

    public List<String> getStringLottos() {
        List<String> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(lotto.toString());
        }
        return result;
    }
}
