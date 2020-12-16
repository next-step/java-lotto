package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    public static int money() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static String lastWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static String bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextLine();
    }

    public static List<String> manualNumbers() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = Integer.parseInt(sc.nextLine());

        if (manualCount == 0) {
            return Collections.emptyList();
        }

        return Stream.generate(sc::nextLine)
              .limit(manualCount)
              .collect(Collectors.toList());
    }
}
