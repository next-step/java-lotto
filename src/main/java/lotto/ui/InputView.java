package lotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    public static int purchase() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int countOfManual() {
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> purchaseManual(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manaulLottos = new ArrayList<>();
        scanner = new Scanner(System.in);
        for (int i = 0; i < count; ++i) {
            manaulLottos.add(scanner.nextLine());
        }
        return manaulLottos;
    }

    public static String winningNumber() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int bonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
