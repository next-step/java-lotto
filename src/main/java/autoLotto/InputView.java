package autoLotto;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    int getLottoBudget() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    String getLottoWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    String getBouns() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
