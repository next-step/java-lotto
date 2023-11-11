package lotto;

import lotto.ui.InputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int money = InputView.inputMoney();
        System.out.println(money);

        List<Integer> integers = InputView.winningNumbers();
        System.out.println(integers);
    }

}
