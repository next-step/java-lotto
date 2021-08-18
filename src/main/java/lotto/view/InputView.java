package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";
    private static final String BLANK = " ";
    private static final String ENTER = "\n";

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println("구매 금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(ENTER + "지난 주 당첨 번호를 입력해 주세요.");
        String[] input = scanner.nextLine().replace(BLANK, "").split(SEPARATOR);

        return Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
