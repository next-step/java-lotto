package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static Scanner SCANNER = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String test = SCANNER.nextLine();
        String input = SCANNER.nextLine();
        List<Integer> numbers = parseNumbers(input);
        return numbers;
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.trim().split(", "))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
