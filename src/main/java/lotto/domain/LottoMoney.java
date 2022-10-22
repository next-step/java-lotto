package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoMoney {

    private static final int LOTTO_PRICE = 1000;
    private final int money;

    private LottoMoney(int lottoMoney) {
        this.money = lottoMoney;
    }

    public static LottoMoney from(int lottoMoney) {
        if (lottoMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("로또의 최소 비용은 1000원 입니다.");
        }
        return new LottoMoney(lottoMoney);
    }

    public int getLottoMoney() {
        return money;
    }

    public int getLottoCount() {
        return money / LOTTO_PRICE;
    }

    public double calYield(long totalPrize) {
        return BigDecimal
            .valueOf(totalPrize)
            .divide(BigDecimal.valueOf(money), 2, RoundingMode.DOWN)
            .doubleValue();
    }
}
