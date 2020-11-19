package lotto.domain;

import lotto.domain.exception.NotValidLottoPriceException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final Random lottoSequence = new Random();

    private LottoMachine machine;

    public Lottos purchase(int purchasePrice, LottoMachine machine) {
        if (purchasePrice < LOTTO_PRICE) {
            throw new NotValidLottoPriceException(LOTTO_PRICE - purchasePrice);
        }
        this.machine = machine;

        return createLotto(purchasePrice / LOTTO_PRICE );
    }

    private Lottos createLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(lottoSequence.nextInt() + i, machine));
        }

        return new Lottos(lottos);
    }

}
