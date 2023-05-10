package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long getLottoCount() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }
}
