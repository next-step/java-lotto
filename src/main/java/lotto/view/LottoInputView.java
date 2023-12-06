package lotto.view;

import lotto.domain.LottoBuyInfo;
import lotto.domain.ManualLottos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

    private static final String NOTICE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String NOTICE_INPUT_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String NOTICE_INPUT_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String NOTICE_INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static LottoBuyInfo inputBuyInfo() {
        System.out.println(NOTICE_INPUT_MONEY);
        int money = stringToInteger(SCANNER.nextLine());
        System.out.println(NOTICE_INPUT_MANUAL_COUNT);
        int manualCount = stringToInteger(SCANNER.nextLine());
        LottoBuyInfo buyInfo = new LottoBuyInfo(money, manualCount);
        return buyInfo;
    }

    private static int stringToInteger(String intString) {
        return Integer.parseInt(intString);
    }

    public static ManualLottos inputManualLottoNumbers(int manualCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(SCANNER.nextLine());
        }
        return new ManualLottos(manualLottos);
    }

    public static String inputWinningNumbers() {
        System.out.println(NOTICE_INPUT_WINNING_NUMBERS);
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(NOTICE_INPUT_BONUS_NUMBER);
        return Integer.parseInt(SCANNER.nextLine());
    }
}
