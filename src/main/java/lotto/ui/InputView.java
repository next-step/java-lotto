package lotto.ui;

import lotto.Message;

import java.util.Scanner;

public class InputView {

    public static int input() {
        System.out.println(Message.INPUT_PURCHASE_PRICE_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
