package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String REQUIRED_INPUT = "입력 값이 null 또는 빈 공백 입니다.";
    private static final String REQUIRED_PURCHASE = "구매금액은 입력해야 합니다.";
    private static final String REQUIRED_NUMBER = "숫자만 입력해야 합니다.";

    private InputView() {}

    public static String purchasePrint() {

        System.out.println("구입금액을 입력해 주세요.");
        final String purchase = SCANNER.next();
        validate(purchase, REQUIRED_PURCHASE);
        return purchase;
    }

    public static String winningLottoPrint() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final String winningLottos = SCANNER.nextLine();
        validate(winningLottos, REQUIRED_INPUT);
        return winningLottos;
    }

    public static String bonusNumberPrint() {

        System.out.println("보너스 볼을 입력해 주세요.");
        final String bonusNumber = SCANNER.next();
        validate(bonusNumber, REQUIRED_INPUT);
        return bonusNumber;
    }

    public static int purchaseManualLottosPrint() {

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            final String countOfManualLottos = SCANNER.next();
            validate(countOfManualLottos, REQUIRED_INPUT);
            return Integer.parseInt(countOfManualLottos);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(REQUIRED_NUMBER);
        }
    }

    public static List<String> manualLottosPrint(final int countOfManualLotto) {

        SCANNER.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottos = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            final String manualLottos = SCANNER.nextLine();
            validate(manualLottos, REQUIRED_INPUT);
            lottos.add(manualLottos);
        }
        return lottos;
    }

    private static void validate(final String input, final String message) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }
}
