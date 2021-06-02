package interaction;

import java.util.Scanner;

import lotto.dto.ManualGameDto;
import lotto.store.Budget;
import lotto.store.ManualCount;

public class InputView {

    private static final String PURCHASE_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Budget budgetLottoPrice() {
        System.out.println(PURCHASE_START_MESSAGE);
        return new Budget(scanner.nextInt());
    }

    public static String winningLottoNumberMessage() {
        System.out.println(WINNING_LOTTO_NUMBER);
        return lottoNumberMessage();
    }

    public static String lottoNumberMessage() {
        String number = scanner.nextLine();
        while (number == null || number.isEmpty()) {
            number = scanner.nextLine();
        }
        return number;
    }

    public static int bonusNumberMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }

    public static ManualGameDto budgetAndManualCount() {
        Budget budget = budgetLottoPrice();
        ManualCount manualCount = manualLottoCount();
        return new ManualGameDto(budget, manualCount);
    }

    private static ManualCount manualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT);
        return new ManualCount(scanner.nextInt());
    }
}
