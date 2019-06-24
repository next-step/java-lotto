package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int askOfAmount() {
        System.out.println("구입할 금액을 입력하세요.");
        int inputOfAmount = scanner.nextInt();
        nextLine();
        return inputOfAmount;
    }

    public static List<Integer> askOfWinningNumbers() {
        System.out.println("당첨번호를 입력하세요.");
        String inputOfWinningNumbers = scanner.nextLine();

        return Arrays.stream(inputOfWinningNumbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void nextLine() {
        scanner.nextLine();
    }
}
