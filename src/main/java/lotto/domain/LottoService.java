package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    private static final int LOTTO_AMOUNT = 1000;

    public int buyTicket(int amount) {
        return amount / LOTTO_AMOUNT;
    }

    public List<Lotto> createLottoTickets(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

}
