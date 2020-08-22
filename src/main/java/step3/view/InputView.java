package step3.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int askQuestion() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int printNumberOfTickets(int amount) {
        System.out.println(amount / 1000 + "개를 구매했습니다.");
        return amount / 1000;
    }

    public static String checkWinNumber() {
        scanner.skip("\\R");
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int checkBonusBallNumber() {
        scanner.skip("\\R");
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
