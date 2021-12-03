package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import lotto.view.TerminalInputView;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        int purchaseAmount = inputView.purchaseAmount();

        LottoPrice lottoPrice = new LottoPrice(purchaseAmount);
        int numberOfTicket = lottoPrice.numberOfTicket();

        Lotto lotto = new Lotto(numberOfTicket);
    }
}
