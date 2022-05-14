package lotto.domain;

import java.util.List;

public class LottoGame {
    private final Money money;
    private Quantity quantity;

    public LottoGame(String buyPrice, String manualBuyCount) {
        this.money = new Money(buyPrice);
        this.quantity = new Quantity(money.getMaxPurchasableQuantity(), manualBuyCount);
    }

    public UserLottos buyLotto(List<String> manualLottos) {
        UserLottos userLottos = new UserLottos();
        manual(manualLottos, userLottos);
        auto(userLottos);
        return userLottos;
    }

    private void manual(List<String> manualLottos, UserLottos userLottos) {
        for (String lotto : manualLottos) {
            userLottos.createManual(new Lotto(lotto));
        }
    }

    private void auto(UserLottos userLottos) {
        while (isPurchasable()) {
            userLottos.createAuto();
            quantity = quantity.increase();
        }
    }

    public double getReturnRate(WinningLotto winningLottoNumber, UserLottos userLottos) {
        return this.money.calculateReturnRate(userLottos.getWinningMoney(winningLottoNumber));
    }

    private boolean isPurchasable() {
        return quantity.isPurchasable();
    }

    public int getMaxPurchasableQuantity() {
        return quantity.getMaxPurchasableQuantity();
    }

    public int getManualBuyCount() {
        return quantity.getManualBuyCount();
    }
}
