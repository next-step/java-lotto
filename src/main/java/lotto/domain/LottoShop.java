package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;
    private static final Random lottoSequence = new Random();

    private LottoMachine machine;

    public Lottos purchase(LottoPrice lottoPrice, LottoMachine machine) {
        this.machine = machine;

        return createLotto(lottoPrice.getPurchasePrice() / LOTTO_PRICE );
    }

    private Lottos createLotto(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(lottoSequence.nextInt() + i, machine));
        }

        return new Lottos(lottos);
    }
}