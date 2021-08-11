package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoTicket> lotto;

    public Lotto() {
        this.lotto = new ArrayList<LottoTicket>();
    }

    public Lotto buyLotto(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 1000원입니다.");
        }
        int lottoCount = price / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new LottoTicket());

        }
        return this;
    }

    public List<LottoTicket> getLotto() {
        return lotto;
    }
}
