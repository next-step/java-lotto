package lottogame.view;

import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int inputBuyPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scan.nextInt();
    }
}
