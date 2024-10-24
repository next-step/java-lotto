package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static String inputLastWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        return bonusNumber;
    }

    public static int inputManualQuantity() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualQuantity = scanner.nextInt();
        scanner.nextLine();
        return manualQuantity;
    }

    public static List<String> inputManualLottoNumbers(int quantity) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> numbers = new ArrayList<>();
        for (int cnt = 0; cnt < quantity; ++cnt) {
            numbers.add(scanner.nextLine());
        }
        return numbers;
    }
}
