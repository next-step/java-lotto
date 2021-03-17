package lotto.view;

import lotto.constant.LottoConstant;

import java.util.Scanner;

public class InputView {

    public int inputBuyAmount() {
        System.out.println(LottoConstant.INPUT_BUY_AMOUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String inputWinnerNumber() {
        System.out.println(LottoConstant.INPUT_WINNER_NUMBERS_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
