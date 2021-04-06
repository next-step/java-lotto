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
    private final Order order;

    public LottoShop(Money money, LottoGenerator lottoGenerator) {
        this.order = new Order(money);
        this.lottoMachine = new LottoMachine(lottoGenerator);
    }

    public LottoShop(Order order, LottoGenerator lottoGenerator) {
        this.order = order;
        this.lottoMachine = new LottoMachine(lottoGenerator);
    }

    public LottoOrderedList purchase() {
        order.balanceWithdraw(new Money(LOTTO_PRICE * order.getOrderedLottoCount()));

        while(isEnoughToPurchase()) {
            order.addOrderedList(lottoMachine.generate());
        }
        return new LottoOrderedList(order);
    }

    private boolean isEnoughToPurchase() {
        return order.balanceWithdraw(new Money(LOTTO_PRICE));
    }
}
