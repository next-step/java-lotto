package lotto.dto;

import lotto.domain.UserLottos;

public class UserLottoInfo {

    private final int purchasePrice;
    private final int quantity;
    private final UserLottos userLottos;

    public UserLottoInfo(int purchasePrice) {
        this.purchasePrice = purchasePrice;
        this.quantity = UserLottos.getLottoQuantity(purchasePrice);
        this.userLottos = new UserLottos(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public UserLottos getUserLottos() {
        return userLottos;
    }
}
