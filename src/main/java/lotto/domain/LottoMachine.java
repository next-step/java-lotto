package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> lottos;

    public LottoMachine(int amount, LottoNumberGenerator lottoNumberGenerator) {
        this.lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            this.lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
    }

    public void start() {

    }
}
