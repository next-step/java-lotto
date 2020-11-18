package lotto.domain;

import lotto.domain.exception.NotValidLottoPriceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final Random lottoSequence = new Random();

    private LottoShop() {
    }

    public static LottoTicket purchase(int purchasePrice) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new NotValidLottoPriceException(LOTTO_PRICE - purchasePrice);
        }
        return new LottoTicket(purchasePrice / LOTTO_PRICE);
    }

    public static Lottos exchangeToLotto(LottoTicket lottoTicket, LottoMachine machine) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicket.getTicketQuantity(); i++) {
            lottos.add(new Lotto(lottoSequence.nextInt() + i, machine));
        }
        return new Lottos(lottos);
    }


}
