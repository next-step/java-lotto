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

    @Override
    public String toString() {
        return lotto.toString();
    }

    public Lotto buyLotto() {
        return this;
    }

    public List<LottoTicket> getLotto() {
        return lotto;
    }
}
