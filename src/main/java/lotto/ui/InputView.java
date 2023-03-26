package lotto.ui;

import java.util.Scanner;

public class InputView {
    public static String getPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String purchaseAmount = scanner.nextLine();
        System.out.println("14개를 구매했습니다.");
        return purchaseAmount;
    }

    public static String getWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String getBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
