package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseResult {

    private final List<Lotto> purchasedLottos;
    private final Money payedMoney;

    public PurchaseResult() {
        this.purchasedLottos = new ArrayList();
        this.payedMoney = new Money(0);
    }

    public PurchaseResult(List<Lotto> purchasedLottos, Money payedMoney) {
        this.purchasedLottos = purchasedLottos;
        this.payedMoney = payedMoney;
    }

    public List<Lotto> getPurchasedLottos() {
        return new ArrayList<>(this.purchasedLottos);
    }

    public Money getPayedMoney() {
        return new Money(payedMoney.getMoney());
    }
}
