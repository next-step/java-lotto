package lottery.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static Integer moneyAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String winPrizeNumbersString(){
        SCANNER.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }
}
