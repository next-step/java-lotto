package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private LottoInputView() {

    }

    public static int inputAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    public static String inputManualLottoNumbers() {
        return SCANNER.nextLine();
    }

    public static String inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int result = SCANNER.nextInt();
        SCANNER.nextLine();
        return result;
    }

    public static List<String> inputManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = SCANNER.nextInt();
        SCANNER.nextLine();

        List<String> result = new ArrayList<>();

        if (count < 0) {
            return result;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            result.add(SCANNER.nextLine());
        }

        return result;
    }
}
