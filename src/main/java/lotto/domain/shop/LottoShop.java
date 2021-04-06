package lotto.domain.shop;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoOrderedList;
import lotto.domain.machine.LottoGenerator;
import lotto.domain.machine.LottoMachine;

public class LottoShop {
    public final static long LOTTO_PRICE = 1000;

    private final LottoMachine lottoMachine;
    private final Money money;

    public LottoShop(Money money, LottoGenerator lottoGenerator) {
        this.money = money;
        this.lottoMachine = new LottoMachine(lottoGenerator);
    }

    public LottoOrderedList purchase() {
        List<Lotto> lottoList = new ArrayList<>();

        while(isEnoughToPurchase()) {
            lottoList.add(lottoMachine.generate());
        }
        return new LottoOrderedList(lottoList);
    }

    public LottoOrderedList purchase(List<Lotto> predefined) {
        while(isEnoughToPurchase()) {
            predefined.add(lottoMachine.generate());
        }
        return new LottoOrderedList(predefined);
    }

    private boolean isEnoughToPurchase() {
        return money.withdraw(new Money(LOTTO_PRICE));
    }
}
