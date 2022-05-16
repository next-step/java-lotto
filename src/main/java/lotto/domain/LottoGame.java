package lotto.domain;

import java.util.List;

public class LottoGame {
    private final Money money;

    private Quantity quantity;
    private UserLottos userLottos;

    public LottoGame(String buyPrice, int manualLottoCount) {
        this.money = new Money(buyPrice);
        this.quantity = new Quantity(money.getMaxPurchasableQuantity(), manualLottoCount);
        this.userLottos = new UserLottos();
    }

    public void buyLotto(UserLottos manualUserLottos) {
        manual(manualUserLottos);
        auto();
    }

    private void manual(UserLottos manualUserLottos) {
        if (manualUserLottos.isEmpty()) {
            return;
        }
        this.userLottos = manualUserLottos;
    }

    private void auto() {
        while (isPurchasable()) {
            userLottos.add(LottoFactory.createAutoLotto());
            quantity = quantity.increase();
        }
    }

    public double getReturnRate(WinningLotto winningLottoNumber) {
        return this.money.calculateReturnRate(userLottos.getWinningMoney(winningLottoNumber));
    }

    private boolean isPurchasable() {
        return quantity.isPurchasable();
    }

    public int getManualBuyCount() {
        return quantity.getManualBuyCount();
    }

    public List<Lotto> getUserLottos() {
        return userLottos.getUserLottos();
    }

    public LottoResults getWinningResults(WinningLotto winningLottoNumber) {
        return userLottos.getWinningResults(winningLottoNumber);
    }

    public int getAutoBuyCount() {
        return quantity.getAutoBuyCount();
    }
}
