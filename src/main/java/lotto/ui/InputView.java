package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }

    public static int inputManualQuantity() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int input = SCANNER.nextInt();
        SCANNER.nextLine();
        return input;
    }

    public static List<String> inputManualNumbers(int manualQuantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < manualQuantity; i++) {
            numbers.add(SCANNER.nextLine());
        }
        return numbers;
    }

    public static List<Integer> inputWinningNumbers(String delimiter) {
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
