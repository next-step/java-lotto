package lotto.step2.domain;

import java.util.ArrayList;

public class Lotto {
    private ArrayList<LottoTicket> lotto;

    public Lotto() {
        this.lotto = new ArrayList<LottoTicket>();
    }

    public ArrayList buyLotto(int price) {
        if (price < 1000) {
            throw new IllegalArgumentException("돈이 부족합니다. 로또 1장의 가격은 1000원입니다.");
        }
        int lottoCount = price / 1000;
        for (int i = 0; i < lottoCount; i++) {
            lotto.add(new LottoTicket());

        }
        return lotto;
    }

    public ArrayList<LottoTicket> getLotto() {
        return lotto;
    }
}
