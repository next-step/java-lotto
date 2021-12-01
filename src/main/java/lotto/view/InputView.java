package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputAmount() {
        return intInput("구입금액을 입력해 주세요.");
    }

    public static List<Integer> inputWinNumbers() {
        String input = stringInput("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String stringInput(String message) {
        print(message);
        return scanner.nextLine();
    }

    private static int intInput(String message) {
        print(message);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
