package lotto.model;

import lotto.strategy.LottoStrategy;
import lotto.strategy.RandomNumber;

import java.util.*;

import static lotto.model.LottoNumbers.*;
import static lotto.model.Lottos.LOTTO_PRICE;

public class LottoFactory {
    private final PurchaseMoney purchaseMoney;

    public LottoFactory(long purchaseMoney) {
        this.purchaseMoney = new PurchaseMoney(purchaseMoney);
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount(); i++) {
            lottos.add(new Lotto(generateRandomSixNumber()));
        }
        return new Lottos(lottos);
    }

    private LottoNumbers generateRandomSixNumber() {
        Set<LottoNumberValidate> numbers = new HashSet<>();
        while (numbers.size() != LOTTO_MAX_COUNT) {
            int randomNumber = generateRandomNumber(new RandomNumber());
            numbers.add(new LottoNumberValidate(randomNumber));
        }
        return new LottoNumbers(numbers);
    }

    private int generateRandomNumber(LottoStrategy lottoStrategy) {
        return lottoStrategy.generateNumber();
    }

    public int lottoCount() {
        return (int) (this.purchaseMoney.money() / LOTTO_PRICE);
    }
}
