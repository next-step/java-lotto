package auto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbersLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersLastWeek = scanner.nextLine();
        return Arrays.stream(winningNumbersLastWeek.split(", "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }
}
