package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutoLottos {
    List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> setLotto(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
