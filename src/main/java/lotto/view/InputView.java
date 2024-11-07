package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return amount;
    }

    public static int inputManualLottoQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoQuantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return manualLottoQuantity;
    }

    public static List<String> inputManualLottoNumbers(int manualLottoQuantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoQuantity; i++) {
            manualLottos.add(scanner.nextLine());
        }
        System.out.println();
        return manualLottos;
    }

    public static String inputLastWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return bonusNumber;
    }
}
