package lotto;

import lotto.view.InputView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();

        int buyAmount = inputView.createBuyAmount();
        System.out.println(buyAmount);

        String winnerNumbers = inputView.createWinnerNumbers();
        System.out.println(winnerNumbers);
    }
}
