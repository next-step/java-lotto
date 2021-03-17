package lotto.view;

import java.util.Scanner;

public class InputView {

    public int inputBuyAmount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
