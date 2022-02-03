package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.lotto.Numbers;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String COMMA = ",";

    private InputView() {}

    public static int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Numbers getComparisonNumbers() {
        scanner.nextLine();
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new Numbers(
            Arrays.stream(scanner.nextLine().split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public static int getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
