package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static int inputPurchaseMoney() {

        System.out.println("구입금액을 입력해 주세요.");
        int purchaseMoney = sc.nextInt();
        sc.nextLine();
        return purchaseMoney;
    }

    public static String inputLastWeekWinnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static String inputBonusNumber() {

        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextLine();
    }

}
