package lotto;

import lotto.domain.LottoPrice;
import lotto.view.TerminalInputView;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        int purchaseAmount = inputView.purchaseAmount();

        LottoPrice lottoPrice = new LottoPrice(purchaseAmount);
        int numberOfTicket = lottoPrice.numberOfTicket();
        System.out.println(numberOfTicket);
    }
}
