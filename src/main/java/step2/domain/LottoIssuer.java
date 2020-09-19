package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoIssuer {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> issueLottos(Money money) {
        List<Lotto> LottoList = new ArrayList<>();

        for (int i = 0, j = money.getNumberOfPurchases(); i < j; i++) {
            LottoList.add(Lotto.create(LottoNumber.getRandomLottoNumber()));
        }

        return LottoList;
    }
}


