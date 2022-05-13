package lotto.domain;

import java.util.List;

public class LottoGame {
    private static final String MAX_QUANTITY_ERROR_MESSAGE = "생성할 수 있는 수량을 초과하였습니다.";

    private final UserLottos userLottos;
    private final Money money;

    public LottoGame(String buyPrice) {
        this(buyPrice, new UserLottos(buyPrice));
    }

    public LottoGame(String buyPrice, UserLottos lottoNumbers) {
        this.userLottos = lottoNumbers;
        this.money = new Money(buyPrice);
    }

    public void auto() {
        validate();
        while (isPurchasable()) {
            userLottos.autoCreate();
        }
    }

    public double getReturnRate(WinningLotto winningLottoNumber) {
        return this.money.calculateReturnRate(userLottos.getWinningMoney(winningLottoNumber));
    }

    public LottoResults getLottoGameResults(WinningLotto winningLottoNumber) {
        return userLottos.getWinningResults(winningLottoNumber);
    }

    private void validate() {
        if (!isPurchasable()) {
            throw new IllegalArgumentException(MAX_QUANTITY_ERROR_MESSAGE);
        }
    }

    private boolean isPurchasable() {
        return userLottos.isPurchasable();
    }

    public int getMaxPurchasableQuantity() {
        return userLottos.getMaxPurchasableQuantity();
    }

    public List<Lotto> getBuyLottoNumbers() {
        return userLottos.getUserLottos();
    }

    @Override
    public String toString() {
        return userLottos.toString();
    }

}
