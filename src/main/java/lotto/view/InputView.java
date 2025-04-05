package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        return getIntInput("구입금액을 입력해 주세요.");
    }

    public static List<Integer> getWinNumbers() {
        String stringInput = getStringInput("지난 주 당첨 번호를 입력해 주세요.");
        return parseIntFromString(stringInput);
    }

    private static List<Integer> parseIntFromString(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getIntInput(String message) {
        String stringInput = getStringInput(message);
        return Integer.parseInt(stringInput);
    }

    private static String getStringInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
