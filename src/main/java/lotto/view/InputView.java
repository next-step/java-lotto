package lotto.view;

import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");

        int payment = scanner.nextInt();
        resetInput();

        System.out.println();

        return payment;
    }

    public static int inputManualNumbersCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scanner.nextInt();

        resetInput();
        System.out.println();

        return count;
    }

    public static List<List<Integer>> inputLottoNumbers(int sheetCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        List<List<Integer>> result = IntStream.range(0, sheetCount)
                .mapToObj(i -> convertToNumbers(scanner.nextLine()))
                .collect(Collectors.toList());

        System.out.println();
        return result;
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
        if (values.isEmpty() || values.isBlank()) {
            throw new IllegalArgumentException("로또 번호가 입력되지 않았습니다.");
        }

        return Arrays.stream(values.replace(" ", "")
                        .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void resetInput() {
        scanner.nextLine();
    }
}
