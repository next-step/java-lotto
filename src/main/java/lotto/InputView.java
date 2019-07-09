package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumber() {
        System.out.println("당첨번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBouseNumber() {
        System.out.println("보너스번호를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualNumberCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualNumber(int manualNumberCount) {
        List<String> manualLottoNumbers = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.nextLine();
        for (int i = 0; i < manualNumberCount; i++) {
            manualLottoNumbers.add(scanner.nextLine());
        }
        return manualLottoNumbers;
    }
}
