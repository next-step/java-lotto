package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lotto;
    public Lotto(int lottoCount) {
        this.lotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new LottoTicket(LottoMachine.mixLottoNumbers()));
        }
    }

    public Lotto getLotto() {
        return this;
    }
}
