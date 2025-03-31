package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수형의 숫자를 입력해주세요.");
        }
    }

    public static String inputWinningNumber() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static void printManualLottoGuide() {
        System.out.println(System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Integer> inputManualLottoNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(",")).map(value -> {
            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("정수형의 숫자를 입력해주세요.");
            }
        }).collect(Collectors.toList());
    }
}
