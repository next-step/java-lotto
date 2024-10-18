package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        int payment = scanner.nextInt();

        resetInput();

        return payment;
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return convertToNumbers(scanner.nextLine());
    }

    public static int inputLottoBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return scanner.nextInt();
    }

    private static List<Integer> convertToNumbers(String values) {
        return Arrays.stream(values.replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void resetInput() {
        scanner.nextLine();
    }
}
