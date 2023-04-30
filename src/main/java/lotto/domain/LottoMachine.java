package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Lotto lotto;

    public LottoMachine(Lotto lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> issueAutoForMoney(Money requestMoney) {
        List<Lotto> lottoList = new ArrayList<>();

        while (requestMoney.isGreaterThanZero()) {
            requestMoney = calculateCurrentMoney(requestMoney);
            Lotto lotto = Lotto.from(new LottoNumberGroup());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    private Money calculateCurrentMoney(Money money) {
        return money.minus(lotto.getLottoFee());
    }

}
