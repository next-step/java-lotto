package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static String purchasePrint() {

        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.next();
    }

    public static String winningLottoPrint() {

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String bonusNumberPrint() {

        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.next();
    }

    public static int purchaseManualLottosPrint() {

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            return Integer.parseInt(SCANNER.next());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }
    }

    public static List<String> manualLottosPrint(final int countOfManualLotto) {

        SCANNER.nextLine();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> lottos = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            String lotto = SCANNER.nextLine();
            lottos.add(lotto);
        }
        return lottos;
    }
}
