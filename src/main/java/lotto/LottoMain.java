package lotto;

import lotto.view.InputView;

public class LottoMain {

    public static void main(String[] args) {
        int fee = InputView.readAmount();
        System.out.println(fee);
    }
}
