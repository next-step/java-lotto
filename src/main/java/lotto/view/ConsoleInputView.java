package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInputView {
    private static final int MIN_MANUAL_TIMES = 1;

    private ConsoleInputView() {
    }

    public static long inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static long inputManualTimes(Scanner scanner) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static List<String> inputManualLottos(Scanner scanner, long times) {
        List<String> lottos = new ArrayList<>();

        if (times < MIN_MANUAL_TIMES) {
            return lottos;
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for (int i = 0; i < times; i++) {
            String lottoNumbers = scanner.nextLine();
            lottos.add(lottoNumbers);
        }

        return lottos;
    }

    public static String inputWinnerNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
