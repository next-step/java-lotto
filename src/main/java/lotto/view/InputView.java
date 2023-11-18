package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.message.LottoErroMessage.OVER_INPUT_MANUAL_COUNT;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static String inputWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int inputManualCount(int lottoCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요. (구매 할 로또 수: " + lottoCount + ")");
        int manualCount = SCANNER.nextInt();
        if (manualCount > lottoCount) {
            throw new IllegalArgumentException(OVER_INPUT_MANUAL_COUNT.message());
        }
        return manualCount;
    }

    public static List<String> inputManualNumber(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String numbers = SCANNER.next();
            manualNumbers.add(numbers);
        }
        return manualNumbers;
    }
}
