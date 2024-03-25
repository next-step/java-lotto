package lotto.view;

import lotto.domain.ManualLottoCount;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_DELIMITER = ", ";

    public static String askPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String askManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static List<String[]> askManualLottoNumbers(ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return Stream.generate(() -> scanner.nextLine().split(SPLIT_DELIMITER))
                .limit(manualLottoCount.value())
                .collect(Collectors.toList());
    }

    public static String[] askWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(SPLIT_DELIMITER);
    }

    public static String askBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
