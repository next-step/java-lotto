package lotto;

import lotto.domain.Lotto;
import lotto.view.InputView;

public class LottoApplication {
    public static void main(String[] args) {
        int purchaseAmount = InputView.inputPurchaseAmount();
        int countOfLotto = purchaseAmount / 1000;
        Lotto lotto = new Lotto(countOfLotto);
        System.out.println(countOfLotto + "개를 구매했습니다.");
    }
}
