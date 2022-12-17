package step2.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputMoney = scanner.nextLine();

        if (InputException.inputAlpha(inputMoney)) {
            scanner = new Scanner(System.in);
            return inputMoney();
        }

        int money = Integer.parseInt(inputMoney);
        int number = money / 1000;

        System.out.println(number);
        System.out.println("개를 구매했습니다.");

        return number;
    }
}
