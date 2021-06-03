package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class AutoLottos {
    public List<Lotto> setLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
