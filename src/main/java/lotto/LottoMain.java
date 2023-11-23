package lotto;


import lotto.view.LottoInputView;

public class LottoMain {
    public static void main(String[] args) {
        LottoInputView lottoInputView = new LottoInputView();
        LottoSimulator lottoSimulator = new LottoSimulator(lottoInputView.inputAmount("구매금액을 입력해주세요."));
        lottoSimulator.run();
    }
}
