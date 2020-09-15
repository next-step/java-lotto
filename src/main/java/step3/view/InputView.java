package step3.view;

import java.util.Scanner;

public class InputView {
    public static int input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        System.out.println(money/1000 + "개를 구매했습니다.");
        return money/1000;
    }

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String number = scanner.nextLine();
        return number;
    }

    public static String inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        String number = scanner.nextLine();
        return number;
    }
}
