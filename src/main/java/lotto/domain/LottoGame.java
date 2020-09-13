package lotto.domain;

import java.util.List;

public class LottoGame {
    public static final Integer DEFAULT_LOTTO_PRICE = 1_000;
    private static final String INVALID_LOTTO_PURCHASE_AMOUNT = "로또 구입 금액이 부족합니다.";
    private static final String INVALID_MANUAL_LOTTO_COUNT = "수동 로또 구입 개수를 확인해 주세요.";

    private final int count;

    private LottoGame(int count) {
        this.count = count;
    }

    public static LottoGame of(int amount, int manualCount) {
        validate(amount, manualCount);
        int count = amount / DEFAULT_LOTTO_PRICE;
        return new LottoGame(count);
    }

    private static void validate(int amount, int manualCount) {
        if (amount < DEFAULT_LOTTO_PRICE) {
            throw new IllegalArgumentException(INVALID_LOTTO_PURCHASE_AMOUNT);
        }

        if(amount < (manualCount * DEFAULT_LOTTO_PRICE)) {
            throw new IllegalArgumentException(INVALID_MANUAL_LOTTO_COUNT);
        }
    }

    public int getCount() {
        return count;
    }

    public Lottos makeLottos(List<String> manualLottos) {
        return Lottos.of(count - manualLottos.size(), manualLottos);
    }
}