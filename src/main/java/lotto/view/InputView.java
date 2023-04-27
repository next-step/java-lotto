package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        final int amount = scanner.nextInt();

        System.out.println();
        return amount;
    }

    public static List<String> manualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        final int manualCount = scanner.nextInt();
        System.out.println();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.nextLine();

        final List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        System.out.println();

        return manualNumbers;
    }

    public static String winningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

    public static int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }
}
