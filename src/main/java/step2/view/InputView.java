package step2.view;

import step2.util.SplitUtil;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String LOTTO_START_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER= "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER= "보너스 볼을 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT= "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER= "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchase() {
        System.out.println(LOTTO_START_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);
        scanner.nextLine();
        return SplitUtil.castingToList(SplitUtil.splitNumber(scanner.nextLine()));
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT);
        return scanner.nextInt();
    }

    public static List<String> inputManualLottoNumber(int manualCount) {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER);
        return IntStream.range(0, manualCount)
                .mapToObj(it -> scanner.next())
                .collect(Collectors.toList());
    }
}
