package lottery.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scan = new Scanner(System.in);

    public static int moneyAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }

    public static String winPrizeNumbersString(){
        scan.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan.nextLine();
    }
}
