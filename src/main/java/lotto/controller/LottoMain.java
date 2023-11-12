package lotto.controller;

import lotto.ui.InputView;

public class LottoMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int price = inputView.inputPrice();
        System.out.println(price);

    }
}
