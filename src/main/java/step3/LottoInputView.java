package step3;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getBudgetWithPrompt(String message) {
        return getIntegerWithMessage(message);
    }

    public static List<Integer> getLastDrawNumbersWithPrompt(String message) {
        System.out.println(message);
        SCANNER.nextLine();     // 엔터값 제거

        return parseLastDrawNumbersString(SCANNER.nextLine());
    }

    private static List<Integer> parseLastDrawNumbersString(String lastDrawResultString) {
        return Arrays.stream(lastDrawResultString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int getBonusNumberWithPrompt(String message) {
        return getIntegerWithMessage(message);
    }

    private static int getIntegerWithMessage(String message) {
        System.out.println(message);

        return SCANNER.nextInt();
    }
}
