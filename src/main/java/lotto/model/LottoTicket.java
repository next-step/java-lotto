package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    public List<LottoNumber> getLotto() {
        return lotto;
    }

    private List<LottoNumber> lotto = new ArrayList<>();

    static public LottoTicket issue() {
        return new LottoTicket();
    }

}
