package step3.ui;

import java.util.Scanner;

public class InputView {


    public static int purchaseAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static String WinningNumbers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }
}
