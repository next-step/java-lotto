package lotto;

import java.util.ArrayList;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public Store() {
    }

    public ArrayList<LottoTicket> buyLotto2 (int money) {
        ArrayList<LottoTicket> lottoTickets = new ArrayList<LottoTicket>();
        Lotto lotto = new Lotto();

        for (int ii = 0; ii < (money/LOTTO_PRICE); ii++)
            lottoTickets.add(lotto.getLottoTicket3());
        return lottoTickets;
    }
}
