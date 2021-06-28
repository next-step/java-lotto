package lottogame.view;

import java.util.Scanner;

public class InputView {
    Scanner scan = new Scanner(System.in);

    public int inputBuyPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public int inputManualBuyPrice() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scan.nextInt();
    }

}
