package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {


    private List<Lotto> lottos;

    public Lottos(Generator lottoNumbers) {
        this.lottos = lottoNumbers.generateLotto();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
