package lotto.model;

import java.util.*;

import static lotto.model.LottoNumbers.*;
import static lotto.model.Lottos.LOTTO_PRICE;
import static lotto.model.PositiveNumber.LOTTO_MAX_RANGE;
import static lotto.model.PositiveNumber.LOTTO_MIN_RANGE;

public class LottoFactory {
    private final long purchaseMoney;

    public LottoFactory(long purchaseMoney) {
        checkMoneyOverThousand(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void checkMoneyOverThousand(long purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다. 현재 "+purchaseMoney+"원을 입력했습니다.");
        }
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount(); i++) {
            lottos.add(new Lotto(generateRandomSixNumber()));
        }
        return new Lottos(lottos);
    }

    private LottoNumbers generateRandomSixNumber() {
        Set<PositiveNumber> numbers = new HashSet<>();
        while (numbers.size() != LOTTO_MAX_COUNT) {
            numbers.add(new PositiveNumber(generateRandomNumber()));
        }
        return new LottoNumbers(numbers);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * LOTTO_MAX_RANGE + LOTTO_MIN_RANGE);
    }

    public int lottoCount() {
        return (int) (this.purchaseMoney / LOTTO_PRICE);
    }
}
