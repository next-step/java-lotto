package lotto.ui;

import java.util.Scanner;

public class InputView {

    public static int purchaseAmount(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

   public static String lottoWinnerNumbers(Scanner scanner) {
       System.out.println("지난주 당첨 번호를 입력해주세요");
       return scanner.nextLine();
   }

}
