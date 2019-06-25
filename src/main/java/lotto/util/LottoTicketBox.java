package lotto.util;

import lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketBox {

    private static final int TICKET_PRICE = 1000;

    public static List<Lotto> buy(int amount) {

        int lottoCount = amount / TICKET_PRICE;

        List<Lotto> lottos = new ArrayList<>();

        for (; lottoCount > 0; lottoCount--) {
            lottos.add(new Lotto(LottoGenerator.generate()));
        }

        return lottos;
    }

}
