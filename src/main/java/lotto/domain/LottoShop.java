package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShop(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public List<Lotto> purchase(Money money) {
        List<Lotto> lottoList = new ArrayList<>();

        while(money.withdraw(LottoConstant.PRICE)) {
            lottoList.add(lottoMachine.generate());
        }
        return lottoList;
    }
}
