package lotto;

import java.util.List;

public class BuyLotto {
    private Money money;
    private List<LottoNumberStrategy> manualLottos;

    public BuyLotto(Money money, List<LottoNumberStrategy> manualLottos) {
        this.money = money;
        this.manualLottos = manualLottos;
    }

    public List<LottoNumberStrategy> getManualLottos() {
        return manualLottos;
    }

    public int manualLottoCount() {
        return manualLottos.size();
    }

    public Money getMoney() {
        return money;
    }
}
