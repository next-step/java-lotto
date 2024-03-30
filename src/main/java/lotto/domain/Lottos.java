package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> autoLottos;

    public Lottos(int size) {
        autoLottos = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            autoLottos.add(new Lotto(new LottoNumbers()));
        }
    }

    public Lottos(List<Lotto> lottosList) {
        autoLottos = lottosList;
    }

    public List<Lotto> of() {
        return autoLottos;
    }
}
