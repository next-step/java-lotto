package lottoauto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 숫자를 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static int price() {
        System.out.println(INPUT_PRICE);
        return convertInteger(scanner.nextLine());
    }

    public static List<Integer> winningNumber() {
        System.out.println(LAST_WINNING_NUMBER);
        return Arrays.stream(scanner.nextLine()
                        .split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static int bonus() {
        System.out.println(INPUT_BONUS);
        return convertInteger(scanner.nextLine());
    }

    private static int convertInteger(String text) {
        return Integer.parseInt(text);
    }

}
