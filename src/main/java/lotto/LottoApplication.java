package lotto;

import lotto.ui.InputView;

public class LottoApplication {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int count = money / 1000;
        System.out.println(count + "개를 구매했습니다.");
    }
}
