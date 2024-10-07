package lotto.domain;

import java.util.List;

public class LottoStore {
    public static final int LOTTO_PURCHASE_AMOUNT = 1000;

    private int money;

    public LottoStore(final int money) {
        if (LOTTO_PURCHASE_AMOUNT > money) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT + "이상의 금액이 필요합니다.");
        }

        if (money % LOTTO_PURCHASE_AMOUNT > 0) {
            throw new IllegalArgumentException("거스름돈이 없습니다. 구매가 불가능합니다.");
        }

        this.money = money;
    }

    public LottoBundle purchase() {
        return new LottoBundle(
            List.of(
                new Lotto(
                    List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(44),
                        new LottoNumber(5),
                        new LottoNumber(6)
                    )
                ),
                new Lotto(
                    List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(44),
                        new LottoNumber(5),
                        new LottoNumber(6)
                    )
                )
            )
        );
    }
}
