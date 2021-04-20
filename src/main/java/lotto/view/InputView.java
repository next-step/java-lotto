package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private InputView() {}

    private static final String INPUT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String LAST_WEEK_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(LAST_WEEK_LOTTO);
        String[] inputNumbers = scanner.nextLine().split(SPLIT_DELIMITER);
        return parseInteger(inputNumbers);
    }

    private static List<Integer> parseInteger(String[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }
}
