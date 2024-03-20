package lotto.dto;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.List;

public class OrderRequest {

    private final Money money;
    private final List<Lotto> manualLottos;

    public OrderRequest(Money money, List<Lotto> manualLottos) {
        this.money = money;
        this.manualLottos = manualLottos;
    }

    public Money getMoney() {
        return money;
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public int automaticQuantity() {
        return money.maxQuantity() - manualLottos.size();
    }

}
