package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String separator = ",";

    public static String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String> inputManualLottoNumbers() {
        return Arrays.asList(scanner.nextLine().split(separator));
    }

    public static List<String> inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.asList(scanner.nextLine().split(separator));
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
