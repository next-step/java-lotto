package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lotto;

    public Lotto() {
        this.lotto = new ArrayList<LottoTicket>();
    }

    public List<LottoTicket> getLotto() {
        return lotto;
    }
}
