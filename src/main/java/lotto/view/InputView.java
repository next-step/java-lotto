package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getAmountOfPurchase() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
