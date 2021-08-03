package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String inputWinningNumber() {
        try{
            scanner.nextLine();
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return scanner.nextLine();
        }finally {
            scanner.close();
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
