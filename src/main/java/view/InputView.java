package view;

import domain.Count;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NUMBER_SPLIT_DELIMITER = ", ";

    private InputView() {
    }

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 정수여야 합니다.");
        }
    }

    public static int readManualPurchaseCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 정수여야 합니다.");
        }
    }

    public static List<List<Integer>> readManualLottoNumbers(Count manualPurchaseCount) {
        if (manualPurchaseCount.isZero()) {
            return Collections.emptyList();
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return LongStream.range(0, manualPurchaseCount.getValue())
            .mapToObj(count -> readLottoNumbers())
            .collect(Collectors.toUnmodifiableList());
    }

    public static List<Integer> readWinningLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");

        return readLottoNumbers();
    }

    private static List<Integer> readLottoNumbers() {
        try {
            final String[] numbers = scanner.nextLine().split(NUMBER_SPLIT_DELIMITER);

            return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "로또번호는 `" + NUMBER_SPLIT_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.");
        }
    }

    public static int readLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 정수여야 합니다.");
        }
    }
}
