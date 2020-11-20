package step2.lotto.automatic.controller;


import step2.lotto.automatic.domain.LottoMatch;
import step2.lotto.automatic.view.InputStep2View;

public class LottoController {

    private static InputStep2View inputStep2View = new InputStep2View();

    public static void main(String[] args) {
        int purchaseAmount = inputStep2View.inputValue();
        LottoMatch lottoMatch = new LottoMatch(purchaseAmount);

        lottoMatch.run();
    }
}
