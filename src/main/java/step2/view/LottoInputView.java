package step2.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputPurchaseManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> inputManualLottoNumbers(int manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            manualNumbers.add(scanner.nextLine());
        }
        return manualNumbers;
    }

    public static String inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputWinningLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
