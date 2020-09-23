package lotto.domain;

import java.util.List;

public class LottoGame {
    public static final Integer DEFAULT_LOTTO_PRICE = 1_000;
    private static final String INVALID_LOTTO_PURCHASE_AMOUNT = "로또 구입 금액이 부족합니다.";
    private static final String INVALID_MANUAL_LOTTO_COUNT = "수동 로또 구입 개수를 확인해 주세요.";

    private final int count;
    private final Lottos lottos;

    private LottoGame(int count, Lottos lottos) {
        this.count = count;
        this.lottos = lottos;
    }

    public static LottoGame of(int amount, int manualCount, List<String> manualLottos) {
        validate(amount, manualCount);
        int count = amount / DEFAULT_LOTTO_PRICE;
        Lottos lottos = Lottos.of(count - manualCount, manualLottos);
        return new LottoGame(count, lottos);
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

    public Lottos getLottos() {
        return lottos;
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }
}