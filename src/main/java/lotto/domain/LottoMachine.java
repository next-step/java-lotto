package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static List<Lotto> issueAutoForMoney(Money requestMoney) {
        List<Lotto> lottoList = new ArrayList<>();

        while (requestMoney.isGreaterThanZero()) {
            requestMoney = calculateCurrentMoney(requestMoney);
            Lotto lotto = Lotto.from(new LottoNumbers());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private static Money calculateCurrentMoney(Money money) {
        return money.minus(Lotto.getLottoFee());
    }

}
