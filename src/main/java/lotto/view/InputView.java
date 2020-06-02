package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private final static String PRINT_REQUIRE_PRICE = "구입금액을 입력해 주세요.";
    private final static String PRINT_REQUIRE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String PRINT_REQUIRE_BONUS = "보너스 볼을 입력해 주세요.";
    private final static String PRINT_REQUIRE_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String PRINT_REQUIRE_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    public static int printRequirePrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_PRICE);

        return scanner.nextInt();
    }

    public static int printRequireManualLottoCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_MANUAL_LOTTO_COUNT);

        return scanner.nextInt();
    }

    public static List<String> printRequireManualLottoNumbers(int manualCount) {
        if (manualCount == 0) {
            return Collections.emptyList();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_MANUAL_LOTTO_NUMBERS);

        return IntStream.range(0, manualCount)
                .mapToObj(i -> scanner.next())
                .collect(Collectors.toList());
    }

    public static String printRequireWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(PRINT_REQUIRE_WINNING_NUMBERS);

        return scanner.nextLine();
    }

    public static int printRequireBonusBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_BONUS);

        return scanner.nextInt();
    }
}
