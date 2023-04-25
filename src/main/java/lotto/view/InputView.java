package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String SPLIT_REGEX = ",";

    public static Long purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static List<Integer> lastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();

        String strNumbers = scanner.nextLine();
        return Arrays.stream(strNumbers.split(SPLIT_REGEX)).map(s -> {
            s = s.trim();
            return Integer.parseInt(s);
        }).collect(Collectors.toList());
    }

    public static int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
