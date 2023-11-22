package lotto;


import lotto.view.LottoInputView;

public class LottoMain {
    public static void main(String[] args) {

        LottoInputView lottoInputView = new LottoInputView();
        int amount = lottoInputView.inputAmount("구매금액을 입력해주세요.");
        String winningNumber = lottoInputView.inputStringLine("당첨번호를 입력해주세요.");


    }
}
