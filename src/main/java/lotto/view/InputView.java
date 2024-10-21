package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ", ";

    public static int inputTotalPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return getInputInteger();
    }

    public static Set<Integer> inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = getInputString();

        return Arrays.stream(inputWinningNumbers.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return getInputInteger();
    }

    private static int getInputInteger() {
        try {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }

    private static String getInputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
