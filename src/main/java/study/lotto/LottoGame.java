package study.lotto;

import java.math.BigDecimal;

public class LottoGame {
    private static BigDecimal lottoPrice = BigDecimal.valueOf(1000);

    public static int purchaseableLotto(BigDecimal amount){
        return amount.divide(lottoPrice).intValue();
    }





}
