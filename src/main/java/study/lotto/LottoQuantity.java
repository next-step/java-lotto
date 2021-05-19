package study.lotto;

import java.math.BigDecimal;

public class LottoQuantity {
    private static BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    private int lottoQuantity;

    public LottoQuantity(int lottoQuantity) {
        this.lottoQuantity = lottoQuantity;
    }

    public static LottoQuantity purchase(BigDecimal amount){
        return new LottoQuantity(amount.divide(lottoPrice).intValue());
    }

    public int getLottoQuantity() {
        return lottoQuantity;
    }
}
