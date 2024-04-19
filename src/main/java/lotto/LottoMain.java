package lotto;

import static lotto.domain.Lotto.purchase;
import static lotto.view.InputView.readInput;

public class LottoMain {
    public static void main(String[] args) {
        String purchaseAmount = readInput("구입금액을 입력해 주세요.");
        purchase(purchaseAmount);

    }
}
