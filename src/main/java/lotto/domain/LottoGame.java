package lotto.domain;

import java.util.List;

public class LottoGame {
    private static final String MAX_QUANTITY_ERROR_MESSAGE = "생성할 수 있는 수량을 초과하였습니다.";

    private final UserLottos userLottos;
    private final Money money;

    public LottoGame(String buyPrice) {
        this(buyPrice, new UserLottos());
    }

    public LottoGame(String buyPrice, UserLottos lottoNumbers) {
        this.userLottos = lottoNumbers;
        this.money = new Money(buyPrice, lottoNumbers.getSize());
    }

    public void auto() {
        validate();
        while (isPurchasable()) {
            userLottos.autoCreate();
            money.addQuantity();
        }
    }

    public double getReturnRate(WinningLotto winningLottoNumber) {
        return this.money.getReturnRate(userLottos.getWinningMoney(winningLottoNumber));
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
        return money.isPurchasable();
    }

    public int getMaxPurchasableQuantity() {
        return money.getMaxPurchasableQuantity();
    }

    public List<Lotto> getBuyLottoNumbers() {
        return userLottos.getUserLottos();
    }

    @Override
    public String toString() {
        return userLottos.toString();
    }

}
