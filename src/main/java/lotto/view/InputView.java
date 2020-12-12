package lotto.view;

import lotto.dto.PurchaseRequest;
import lotto.dto.WinningRequest;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";

    private static final String INPUT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    private static final String INPUT_MANUAL_LOTTO = "수동으로 구매할 번호를 입력해 주세요.";

    private static final String INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String INPUT_BONUS_LOTTO = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static PurchaseRequest purchase() {
        long amount = inputAmount();

        List<String> manualNumbers = inputManualNumbers();

        return new PurchaseRequest(amount, manualNumbers);
    }

    private static long inputAmount() {
        System.out.println(INPUT_AMOUNT);
        return Long.parseLong(scanner.nextLine());
    }

    private static List<String> inputManualNumbers() {
        System.out.println(INPUT_MANUAL_COUNT);
        int manualCount = Integer.parseInt(scanner.nextLine());
        System.out.println(INPUT_MANUAL_LOTTO);
        return IntStream.range(0, manualCount)
                .mapToObj(ignore -> inputManualNumber())
                .collect(Collectors.toList());
    }

    private static String inputManualNumber() {
        return scanner.nextLine();
    }

    public static WinningRequest winningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        String winnerNumbers = scanner.nextLine();
        System.out.println(INPUT_BONUS_LOTTO);
        String bonusNumber = scanner.nextLine();
        return new WinningRequest(winnerNumbers, bonusNumber);
    }
}
