package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> lottos;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
    }

    public void issueLottos(final int quantity, LottoNumberGenerator lottoNumberGenerator) {
        for (int i = 0; i < quantity; i++) {
            this.lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }
}
