package View;


import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int insertBuyPrice() {

        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static String insertLastWeekWinningNumber() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.next();
    }
    public static int insertBonusNumber() {

        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }

}
