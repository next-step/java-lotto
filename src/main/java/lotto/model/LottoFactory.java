package lotto.model;

import java.util.*;

public class LottoFactory {
    private static final int LOTTO_PRICE = 1000;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_SIZE = 6;
    private final int purchaseMoney;

    public LottoFactory(int purchaseMoney) {
        checkMoneyOverThousand(purchaseMoney);
        this.purchaseMoney = purchaseMoney;
    }

    private void checkMoneyOverThousand(int purchaseMoney) {
        if (purchaseMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount(); i++) {
            lottos.add(new Lotto(generateRandomSixNumber()));
        }
        return new Lottos(lottos);
    }

    public LottoNumbers generateRandomSixNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() != MAX_LOTTO_SIZE) {
            numbers.add(generateRandomNumber());
        }
        return new LottoNumbers(numbers);
    }

    int generateRandomNumber() {
        return (int) (Math.random() * MAX_LOTTO_NUMBER + MIN_LOTTO_NUMBER);
    }

    public int lottoCount() {
        return this.purchaseMoney / LOTTO_PRICE;
    }
}
