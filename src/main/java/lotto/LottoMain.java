package lotto;

import lotto.view.TerminalInputView;

public class LottoMain {

    public static void main(String[] args) {
        TerminalInputView inputView = new TerminalInputView();
        int purchaseAmount = inputView.purchaseAmount();
    }
}
