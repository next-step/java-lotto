package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Integer> inputWinningNumbers(String delimiter) {
        SCANNER.nextLine();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(SCANNER.nextLine().split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
