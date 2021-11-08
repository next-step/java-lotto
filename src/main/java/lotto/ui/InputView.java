package lotto.ui;

import lotto.utils.InputUtils;
import lotto.validator.LottoValidator;

public class InputView {

    public Integer inputPurchasePrice() {
        Integer purchasePrice = InputUtils.inputInt("구입금액을 입력해 주세요.");
        LottoValidator.checkMinimumPurchasePrice(purchasePrice);
        return purchasePrice;
    }

}
